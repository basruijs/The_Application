package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.NawDto;
import com.itvitae.swdn.dto.PersonGetDto;
import com.itvitae.swdn.dto.PersonPostDto;
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

    //CREATE
    public void addPerson(PersonPostDto personDto) {
        Person newPerson = personMapper.toEntity(personDto);
        personRepository.save(newPerson);
    }

    //READ
    public PersonGetDto getPersonById(long id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (!foundPerson.isPresent() || foundPerson.get().isDeleted()) {
            throw new IllegalArgumentException("No such person exists");
        }
        return personMapper.toDto(foundPerson.get());
    }

    public Iterable<PersonGetDto> getAllPeople() {
        return StreamSupport
                .stream(personRepository.findAll().spliterator(), false)
                .filter(person -> !person.isDeleted())
                .map(person -> personMapper.toDto(person))
                .collect(Collectors.toList());
    }

    public Iterable<PersonGetDto> getTrainees(long id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (!foundPerson.isPresent()) {
            throw new IllegalArgumentException("No such person exists");
        }
        return foundPerson.get().getTrainees().stream()
                .filter(person -> !person.isDeleted())
                .map(person -> personMapper.toDto(person))
                .collect(Collectors.toList());
    }

    public Iterable<PersonGetDto> getSubordinates(long id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (!foundPerson.isPresent()) {
            throw new IllegalArgumentException("No such person exists");
        }
        return foundPerson.get().getSubordinates().stream()
                .filter(person -> !person.isDeleted())
                .map(person -> personMapper.toDto(person))
                .collect(Collectors.toList());
    }

    public void updatePersonById(long id, NawDto nawDto) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (!foundPerson.isPresent()) {
            throw new IllegalArgumentException("No such person exists");
        }
        Person person = foundPerson.get();
        if (nawDto.getName() != null) {
            person.setName(nawDto.getName());
        }
        if (nawDto.getAddress() != null) {
            person.setAddress(nawDto.getAddress());
        }
        if (nawDto.getCity() != null) {
            person.setCity(nawDto.getCity());
        }

        personRepository.save(person);
    }

    public void setPeople(long id, long coachid, long managerid) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (!foundPerson.isPresent()) {
            throw new IllegalArgumentException("No such person exists");
        }
        Person person = foundPerson.get();
        Optional<Person> foundCoach = personRepository.findById(coachid);
        if (foundCoach.isPresent()) {
            if (person.getCoach() != null) {
                person.getCoach().getTrainees().remove(person);
                personRepository.save(person.getCoach());
            }
            Person coach = foundCoach.get();
            person.setCoach(coach);
            coach.getTrainees().add(person);
            personRepository.save(coach);
        }
        Optional<Person> foundManager = personRepository.findById(managerid);
        if (foundManager.isPresent()) {
            if (person.getManager() != null) {
                person.getManager().getSubordinates().remove(person);
                personRepository.save(person.getManager());
            }
            Person manager = foundManager.get();
            person.setManager(manager);
            manager.getSubordinates().add(person);
            personRepository.save(manager);
        }
        personRepository.save(person);
    }


}
