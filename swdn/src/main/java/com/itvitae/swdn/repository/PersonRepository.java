package com.itvitae.swdn.repository;

import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.Role;
import com.itvitae.swdn.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    boolean existsByRole(Role role);

}
