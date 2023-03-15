package com.itvitae.swdn.repository;

import com.itvitae.swdn.model.ChangeRequest;
import com.itvitae.swdn.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChangeRequestRepository extends CrudRepository<ChangeRequest, Long> {
    Optional<ChangeRequest> findByRequester(Person requester);
}
