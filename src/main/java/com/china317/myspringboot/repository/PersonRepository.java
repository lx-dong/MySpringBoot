package com.china317.myspringboot.repository;

import com.china317.myspringboot.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lx-dong on 2017/10/27.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

}
