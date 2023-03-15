package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.ChangeRequestDto;
import com.itvitae.swdn.mapper.ChangeRequestMapper;
import com.itvitae.swdn.model.ChangeRequest;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.Skill;
import com.itvitae.swdn.repository.ChangeRequestRepository;
import com.itvitae.swdn.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
