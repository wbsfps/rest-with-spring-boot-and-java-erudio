package br.com.WorkingWithDTOPattern.repository;

import br.com.WorkingWithDTOPattern.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
