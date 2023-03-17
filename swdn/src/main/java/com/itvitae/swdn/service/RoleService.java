package com.itvitae.swdn.service;


import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.mapper.PersonMapper;
import com.itvitae.swdn.mapper.RoleMapper;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.Role;
import com.itvitae.swdn.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PersonMapper personMapper;


    public void addPersonToRole(Person person) {
        Role role = person.getRole();
        role.getPeople().add(person);
        roleRepository.save(role);
    }


    //READ
    public Role getRoleById(long id) {
        Optional<Role> foundRole = roleRepository.findById(id);
        if (!foundRole.isPresent()) {
            throw new IllegalArgumentException("No such role");
        }
        return foundRole.get();
    }

    public Iterable<PersonGetDto> getAllTrainees() {
        Optional<Role> foundRole = roleRepository.findByName("TRAINEE");
        if (!foundRole.isPresent()) {
            throw new IllegalArgumentException("Role 'trainee' does not exist");
        }
        return foundRole.get()
                .getPeople().stream()
                .map(person -> personMapper.toDto(person))
                .collect(Collectors.toList());
    }

    public Iterable<PersonGetDto> getAllOfRole(String roleName) {
        Optional<Role> foundRole = roleRepository.findByName(roleName);
        if (!foundRole.isPresent()) {
            throw new IllegalArgumentException("Role '" + roleName + "' does not exist");
        }
        return foundRole.get()
                .getPeople().stream()
                .map(person -> personMapper.toDto(person))
                .collect(Collectors.toList());
    }
}
