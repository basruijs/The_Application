package com.itvitae.swdn.repository;

import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
    boolean existsByNameAndTraineeAndDeleted(String name, Person trainee, boolean deleted);
}
