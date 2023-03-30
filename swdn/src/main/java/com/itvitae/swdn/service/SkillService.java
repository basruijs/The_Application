package com.itvitae.swdn.service;

import com.itvitae.swdn.dto.SkillGetDto;
import com.itvitae.swdn.dto.SkillPostDto;
import com.itvitae.swdn.dto.SkillPutDto;
import com.itvitae.swdn.mapper.SkillMapper;
import com.itvitae.swdn.model.DBFile;
import com.itvitae.swdn.model.Person;
import com.itvitae.swdn.model.Skill;
import com.itvitae.swdn.repository.DBFileRepository;
import com.itvitae.swdn.repository.PersonRepository;
import com.itvitae.swdn.repository.SkillRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class SkillService {

    @Autowired
    SkillMapper skillMapper;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DBFileStorageService dbFileStorageService;

    @Autowired
    DBFileRepository dbFileRepository;

    public Iterable<SkillGetDto> getAllSkills() {
        return StreamSupport
                .stream(skillRepository.findAll().spliterator(), false)
                .filter(skill -> !skill.isDeleted())
                .map(skill -> skillMapper.toDto(skill))
                .collect(Collectors.toList());
    }

    public Iterable<SkillGetDto> getSkillByPerson(long traineeid) {
        return StreamSupport
                .stream(skillRepository.findAll().spliterator(), false)
                .filter(skill -> Objects.equals(skill.getTrainee().getId(), traineeid))
                .filter(skill -> !skill.isDeleted())
                .map(skill -> skillMapper.toDto(skill))
                .collect(Collectors.toList());
    }

    public SkillGetDto getSkillById(long id) {
        Optional<Skill> foundSkill = skillRepository.findById(id);
        if (!foundSkill.isPresent() || foundSkill.get().isDeleted()) {
            throw new IllegalArgumentException("No such skill exists");
        }
        return skillMapper.toDto(foundSkill.get());
    }

    public void newSkill(SkillPostDto skillDto, long personid) {
        Skill newSkill = skillMapper.toEntity(skillDto);
        Optional<Person> foundPerson = personRepository.findById(personid);
        if (!foundPerson.isPresent()) {
            throw new IllegalArgumentException("Person does not exist");
        }
        Person person = foundPerson.get();
        if (skillRepository.existsByNameAndTraineeAndDeleted(newSkill.getName(), person, false)) {
            throw new IllegalArgumentException("Duplicate skill name");
        }
        person.getSkills().add(newSkill);
        newSkill.setTrainee(person);
        skillRepository.save(newSkill);
    }

    public void updateSkill(long id, SkillPutDto skill) {
        if (!skillRepository.existsById(id)) {
            //do nothing
        } else {
            Skill oldSkill = skillRepository.findById(id).get();
            if (skill.getName() != null) {
                oldSkill.setName(skill.getName());
            }
            if (skill.getHardSkill() != null) {
                oldSkill.setHardSkill(skill.getHardSkill());
            }
            if (skill.getCompleted() != null) {
                oldSkill.setCompleted(skill.getCompleted());
            }
            if (skill.getReport() != null) {
                oldSkill.setReport(skill.getReport());
            }
            if (skill.getLearningGoals() != null) {
                oldSkill.setLearningGoals(skill.getLearningGoals());
            }
            if (skill.getDescription() != null) {
                oldSkill.setDescription(skill.getDescription());
            }


            skillRepository.save(oldSkill);
        }
    }

    public void addCertificate(long id, MultipartFile file) throws IOException {
        Optional<Skill> foundSkill = skillRepository.findById(id);
        if (!foundSkill.isPresent()) {
            throw new IllegalArgumentException("No such skill exists");
        }
        Skill skill = foundSkill.get();
        DBFile dbFile = dbFileStorageService.storeFile(file);
        skill.setCertificate(dbFile);
        skillRepository.save(skill);
        dbFile.setSkill(skill);
        dbFileRepository.save(dbFile);
    }

    public ResponseEntity<Resource> downloadCertificate(long id) {
        Optional<Skill> foundSkill = skillRepository.findById(id);
        if (!foundSkill.isPresent()) {
            throw new IllegalArgumentException("No such skill exists");
        }
        DBFile dbFile = foundSkill.get().getCertificate();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    public void deleteSkillById(long id) {
        if (!skillRepository.existsById(id)) {
            throw new IllegalArgumentException("No such skill exists");
        }
        Skill skill = skillRepository.findById(id).get();
        skill.setDeleted(true);
    }
}
