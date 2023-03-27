package com.itvitae.swdn.repository;

import com.itvitae.swdn.model.SkillTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTemplateRepository extends CrudRepository<SkillTemplate, Long> {
}
