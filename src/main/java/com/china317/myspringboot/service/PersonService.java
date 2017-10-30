package com.china317.myspringboot.service;

import com.china317.myspringboot.entity.Person;
import com.china317.myspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by lx-dong on 2017/10/27.
 */
@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    
    public Person save(Person person){
       return personRepository.save(person);
    }

    public Person findOne(Long id){
        return personRepository.findOne(id);
    }
}
