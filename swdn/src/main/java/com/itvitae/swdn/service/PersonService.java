package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.mapper.PersonMapper;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;

    public PersonGetDto getPersonById(long id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (!foundPerson.isPresent()) {
            throw new IllegalArgumentException("No such person exists");
        }
        return personMapper.toDto(foundPerson.get());
    }

    public Iterable<PersonGetDto> getAllPeople() {
        return StreamSupport
                .stream(personRepository.findAll().spliterator(), false)
                .map(person -> personMapper.toDto(person))
                .collect(Collectors.toList());
    }
}
