package com.china317.myspringboot.repository.first;

import com.china317.myspringboot.entity.first.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lx-dong on 2017/10/27.
 */
public interface PersonDao extends CrudRepository<Person, Long> {

}
