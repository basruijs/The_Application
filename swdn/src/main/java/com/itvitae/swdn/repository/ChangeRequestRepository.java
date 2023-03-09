package com.itvitae.swdn.repository;

import com.itvitae.swdn.model.ChangeRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRequestRepository extends CrudRepository<ChangeRequest, Long> {
}
