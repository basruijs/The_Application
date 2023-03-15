package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.ChangeRequestDto;
import com.itvitae.swdn.dto.ChangeRequestGetDto;
import com.itvitae.swdn.mapper.ChangeRequestMapper;
import com.itvitae.swdn.model.ChangeRequest;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.repository.ChangeRequestRepository;
import com.itvitae.swdn.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ChangeRequestService {

    @Autowired
    ChangeRequestRepository changeRequestRepository;

    @Autowired
    ChangeRequestMapper changeRequestMapper;

    @Autowired
    PersonRepository personRepository;

    public void addChangeRequest(ChangeRequestDto changeRequestDto, long personid) {
        ChangeRequest newChangeRequest = changeRequestMapper.toEntity(changeRequestDto);
        Person person = personRepository.findById(personid).get();
        person.setChangeRequest(newChangeRequest);
        newChangeRequest.setRequester(person);
        changeRequestRepository.save(newChangeRequest);
    }

    public ChangeRequestGetDto getRequestByPerson(long id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (!foundPerson.isPresent()) {
            throw new IllegalArgumentException("No such person");
        }
        Person person = foundPerson.get();
        Optional<ChangeRequest> foundRequest = changeRequestRepository.findFirstByRequester(person);
        return foundRequest.map(changeRequest -> changeRequestMapper.toDto(changeRequest)).orElse(new ChangeRequestGetDto());
    }

    public void deleteChangeRequest(long id) {
        if (!changeRequestRepository.existsById(id)) {
            throw new IllegalArgumentException("No such request");
        }
        changeRequestRepository.deleteById(id);
    }
}
