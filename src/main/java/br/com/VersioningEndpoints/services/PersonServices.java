package br.com.VersioningEndpoints.services;

import br.com.VersioningEndpoints.data.dto.v1.PersonDTO;
import br.com.VersioningEndpoints.data.dto.v2.PersonDTOV2;
import br.com.VersioningEndpoints.exception.ResourceNotFoundException;
import br.com.VersioningEndpoints.model.Person;
import br.com.VersioningEndpoints.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static br.com.WorkingWithDTOPattern.mapper.ObjectMapper.parseListObjects;
import static br.com.WorkingWithDTOPattern.mapper.ObjectMapper.parseObject;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records not found this ID"));
        return parseObject(entity, PersonDTO.class);
    }

    public List<PersonDTO> findByAll() {
        logger.info("Find All People");
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one person!");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one person!");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTOV2.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Update one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records not found this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records not found this ID"));
        repository.delete(entity);
    }
}
