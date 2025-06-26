package br.com.LogsInSpringBoot.repository;

import br.com.LogsInSpringBoot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
