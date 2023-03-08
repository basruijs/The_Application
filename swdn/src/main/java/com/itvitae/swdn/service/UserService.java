package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.mapper.UserMapper;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.User;
import com.itvitae.swdn.repository.PersonRepository;
import com.itvitae.swdn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void newUser(UserPostDto userPostDto, long roleid) {
        User newUser = userMapper.toEntity(userPostDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Person person = personRepository.save(newUser.getPerson());
        newUser.setPerson(person);
        User newerUser = userRepository.save(newUser);
        person.setUser(newerUser);
        person.setRole(roleService.getRoleById(roleid));
        roleService.addPersonToRole(personRepository.save(person));
    }
}
