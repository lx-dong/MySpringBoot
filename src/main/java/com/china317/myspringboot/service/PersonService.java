package com.china317.myspringboot.service;

import com.china317.myspringboot.entity.first.Person;
import com.china317.myspringboot.repository.first.PersonDao;
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
    PersonDao personDao;
    
    public Person save(Person person){
       return personDao.save(person);
    }

    public Person findOne(Long id){
        return personDao.findOne(id);
    }
}
