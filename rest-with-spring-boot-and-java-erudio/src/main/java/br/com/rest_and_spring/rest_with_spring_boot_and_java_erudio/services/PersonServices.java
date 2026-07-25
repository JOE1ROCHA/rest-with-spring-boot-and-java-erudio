package br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.services;

import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.Exception.ResourceNotFoudException;
import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.data.dto.PersonDTO;
import static br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.mapper.ObjectMapper.parseListObject;
import static br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.mapper.ObjectMapper.parseObject;
import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.model.Person;
import br.com.rest_and_spring.rest_with_spring_boot_and_java_erudio.repository.PersonRepository;
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
    PersonRepository repository;

    public List<PersonDTO> findAll(){
        logger.info("finding all People");

        return parseListObject(repository.findAll(), PersonDTO.class);
    }


    public PersonDTO findById(Long id){

        logger.info("finding one Person");

        var entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoudException("No records found for this ID!"));

        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){

        logger.info("creating one Person");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class) ;
    }

    public PersonDTO update(PersonDTO person){

        logger.info("updating one Person");

        Person entity = repository.findById(person.getId()).
                orElseThrow(()-> new ResourceNotFoudException("No records found for this ID!"));

        entity.setNome(person.getNome());
        entity.setIdade(person.getIdade());
        entity.setNacionalidade(person.getNacionalidade());
        entity.setGenero(person.getGenero());

        return parseObject(repository.save(entity), PersonDTO.class) ;

    }

    public void delete(Long id){
        logger.info("deleting one person");

        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoudException("No records found for this ID!"));

        repository.delete(entity);
    }
}
