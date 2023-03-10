package com.itvitae.swdn.configuration;

import com.itvitae.swdn.model.Role;
import com.itvitae.swdn.model.User;
import com.itvitae.swdn.repository.RoleRepository;
import com.itvitae.swdn.repository.UserRepository;
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

        User user = new User("admin", passwordEncoder.encode("admin"), "ROLE_HR");
        userRepository.save(user);
    }
}
