package br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.repository;

import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.model.Person;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long> {
}
