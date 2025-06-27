package br.com.MigrationsWithFlyWay.repository;

import br.com.MigrationsWithFlyWay.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
