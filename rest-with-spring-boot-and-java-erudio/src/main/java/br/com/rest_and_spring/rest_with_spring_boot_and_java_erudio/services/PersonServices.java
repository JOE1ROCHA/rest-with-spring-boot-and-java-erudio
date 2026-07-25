package br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.services;

import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.Exception.ResourceNotFoudException;
import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.model.Person;
import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("finding all People");

        return repository.findAll();
    }


    public Person findById(Long id){

        logger.info("finding one Person");

        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoudException("No records found for this ID!"));
    }
    public Person create(Person person){

        logger.info("creating one Person");
        return repository.save(person);
    }
    public Person update(Person person){

        logger.info("updating one Person");

        Person entity = repository.findById(person.getId()).
                orElseThrow(()-> new ResourceNotFoudException("No records found for this ID!"));

        entity.setNome(person.getNome());
        entity.setIdade(person.getIdade());
        entity.setNacionalidade(person.getNacionalidade());
        entity.setGenero(person.getGenero());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("deleting one person");

        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoudException("No records found for this ID!"));

        repository.delete(entity);
    }
}
