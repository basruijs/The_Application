package com.itvitae.swdn.configuration;

import com.itvitae.swdn.dto.PersonPostDto;
import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.model.Role;
import com.itvitae.swdn.repository.RoleRepository;
import com.itvitae.swdn.repository.UserRepository;
import com.itvitae.swdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Setup {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserService userService;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Role trainee = new Role("TRAINEE");
        roleRepository.save(trainee);
        Role coach = new Role("COACH");
        roleRepository.save(coach);
        Role manager = new Role("MANAGER");
        roleRepository.save(manager);
        Role hr = new Role("HR");
        roleRepository.save(hr);

        PersonPostDto adminPerson = new PersonPostDto();
        adminPerson.setName("Admin");
        adminPerson.setCity("Admin city");
        adminPerson.setAddress("Admin address");


        UserPostDto admin = new UserPostDto();
        admin.setEmail("admin@admin.nl");
        admin.setPassword("admin");
        admin.setRoles("ROLE_HR");
        admin.setPerson(adminPerson);

        userService.newUser(admin, 4);
        PersonPostDto trainee1Person = new PersonPostDto();
        trainee1Person.setName("Trenée");
        trainee1Person.setCity("trainee city");
        trainee1Person.setAddress("trainee address");


        UserPostDto trainee1User = new UserPostDto();
        trainee1User.setEmail("trainee@trainee.nl");
        trainee1User.setPassword("trainee");
        trainee1User.setRoles("ROLE_TRAINEE");
        trainee1User.setPerson(trainee1Person);

        userService.newUser(trainee1User, 1);

        PersonPostDto mangoPerson = new PersonPostDto();
        mangoPerson.setName("Magnificent Mangoes");
        mangoPerson.setCity("trainee city");
        mangoPerson.setAddress("trainee address");


        UserPostDto mangoUser = new UserPostDto();
        mangoUser.setEmail("magnificentmangoes.com@gmail.com");
        mangoUser.setPassword("mango");
        mangoUser.setRoles("ROLE_TRAINEE");
        mangoUser.setPerson(mangoPerson);

        userService.newUser(mangoUser, 1);

    }
}
