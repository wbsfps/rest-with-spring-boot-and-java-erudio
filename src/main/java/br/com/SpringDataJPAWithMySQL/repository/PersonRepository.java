package br.com.SpringDataJPAWithMySQL.repository;

import br.com.SpringDataJPAWithMySQL.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
