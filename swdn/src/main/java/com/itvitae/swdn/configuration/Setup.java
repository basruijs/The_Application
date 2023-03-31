package com.itvitae.swdn.configuration;

import com.itvitae.swdn.dto.PersonPostDto;
import com.itvitae.swdn.dto.UserPostDto;
import com.itvitae.swdn.model.Role;
import com.itvitae.swdn.repository.PersonRepository;
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
    PersonRepository personRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserService userService;


    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if(!roleRepository.findByName("TRAINEE").isPresent()) {
            Role trainee = new Role("TRAINEE");
            roleRepository.save(trainee);
        }

        if(!roleRepository.findByName("COACH").isPresent()) {
            Role coach = new Role("COACH");
            roleRepository.save(coach);
        }

        if(!roleRepository.findByName("MANAGER").isPresent()) {
            Role manager = new Role("MANAGER");
            roleRepository.save(manager);
        }

        if(!roleRepository.findByName("HR").isPresent()) {
            Role hr = new Role("HR");
            roleRepository.save(hr);
        }

        if(personRepository.existsByRole(roleRepository.findByName("HR").get())) {
            PersonPostDto adminPerson = new PersonPostDto();
            adminPerson.setName("Admin");
            adminPerson.setCity("Admin city");
            adminPerson.setAddress("Admin address");


            UserPostDto admin = new UserPostDto();
            admin.setEmail("admin@admin.nl");
            admin.setPassword("admin");
            admin.setRoles("ROLE_HR");
            admin.setPerson(adminPerson);

            userService.newAdmin(admin, 4);
        }
    }
}
