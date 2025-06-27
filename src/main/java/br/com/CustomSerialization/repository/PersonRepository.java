package br.com.CustomSerialization.repository;

import br.com.CustomSerialization.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
