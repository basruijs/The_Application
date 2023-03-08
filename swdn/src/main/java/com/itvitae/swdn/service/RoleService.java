package com.itvitae.swdn.service;

import com.itvitae.swdn.mapper.RoleMapper;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.Role;
import com.itvitae.swdn.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

    public void addPersonToRole(Person person) {
        Role role = person.getRole();
        role.getPeople().add(person);
        roleRepository.save(role);
    }

    //CREATE
    public void addRoleByName(String name) {
        Role newRole = new Role();
        newRole.setName(name);
        roleRepository.save(newRole);
    }

    //READ
    public Role getRoleById(long id) {
        Optional<Role> foundRole = roleRepository.findById(id);
        if (!foundRole.isPresent()) {
            throw new IllegalArgumentException("No such role");
        }
        return foundRole.get();
    }
}
