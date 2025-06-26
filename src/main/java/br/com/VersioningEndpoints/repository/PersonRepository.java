package br.com.VersioningEndpoints.repository;

import br.com.VersioningEndpoints.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
