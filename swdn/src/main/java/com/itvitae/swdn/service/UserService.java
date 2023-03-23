package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.LoginRequest;
import com.itvitae.swdn.dto.PasswordChange;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.mapper.PersonMapper;
import com.itvitae.swdn.mapper.UserMapper;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.User;
import com.itvitae.swdn.repository.PersonRepository;
import com.itvitae.swdn.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void newUser(UserPostDto userPostDto, long roleid) {
        User newUser = userMapper.toEntity(userPostDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Person person = personRepository.save(newUser.getPerson());
        newUser.setPerson(person);
        User newerUser = userRepository.save(newUser);
        person.setUser(newerUser);
        person.setRole(roleService.getRoleById(roleid));

        String emailText = "Hello " + person.getName() + ", \n\n"
                + "An account has been created for you.\n"
                + "To log in, use the email " + newerUser.getEmail() + " and the password \"password\"\n"
                + "Once you are logged in, it is recommended you change your password.";

        emailService.sendEmail(newerUser.getEmail(), "Your account has been created", emailText);

        roleService.addPersonToRole(personRepository.save(person));
    }

    public PersonGetDto login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Optional<User> foundUser = userRepository.findByEmail(loginRequest.getEmail());
        if (!foundUser.isPresent()) {
            throw new IllegalStateException("Logged in as nonexistent user");
        }
        Person person = foundUser.get().getPerson();
        return personMapper.toDto(person);
    }

    public void updatePassword(PasswordChange newCredentials) {
        Optional<User> foundUser = userRepository.findByEmail(newCredentials.getEmail());
        if (!foundUser.isPresent()) {
            throw new IllegalArgumentException("No such user exists");
        }
        User user = foundUser.get();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        newCredentials.getOldPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        user.setPassword(passwordEncoder.encode(newCredentials.getNewPassword()));
        userRepository.save(user);
    }

    public void newAdmin(UserPostDto userPostDto, long roleid) {
        User newUser = userMapper.toEntity(userPostDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Person person = personRepository.save(newUser.getPerson());
        newUser.setPerson(person);
        User newerUser = userRepository.save(newUser);
        person.setUser(newerUser);
        person.setRole(roleService.getRoleById(roleid));

        roleService.addPersonToRole(personRepository.save(person));
    }

    public void deleteUserById(long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("No such user exists");
        }

        User executeeUser = userRepository.findById(id).get();
        Person executeePerson = executeeUser.getPerson();
        long personId = executeePerson.getId();

        personRepository.deleteById(personId);
        userRepository.deleteById(id);
    }
}
