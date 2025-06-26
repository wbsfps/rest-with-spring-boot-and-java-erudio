package br.com.LogsInSpringBoot.services;

import br.com.LogsInSpringBoot.exception.ResourceNotFoundException;
import br.com.LogsInSpringBoot.model.Person;
import br.com.LogsInSpringBoot.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    public Person findById(Long id) {
        logger.info("Finding one Person!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records not found this ID"));
    }

    public List<Person> findByAll() {
        logger.info("Find All People");
        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records not found this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records not found this ID"));
        repository.delete(entity);
    }
}
