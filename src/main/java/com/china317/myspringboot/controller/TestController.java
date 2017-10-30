package com.china317.myspringboot.controller;

import com.china317.myspringboot.entity.Person;
import com.china317.myspringboot.repository.PersonRepository;
import com.china317.myspringboot.service.PersonService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lx-dong on 2017/10/27.
 */
@RestController
//@ComponentScan
public class TestController {

    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/index")
    public JsonNode helloWorld(){
        ObjectNode result = new ObjectMapper().createObjectNode();
        result.put("msg", "Hello World!");
        return result;
    }

    @RequestMapping("/save")
    public Map<String, Object> save(){
        Person p = new Person("小明", "man");
        Person p2 = personService.save(p);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("entity", p2);
        return result;
    }

    @RequestMapping("/find")
    public Map<String, Object> find(){
        Map<String, Object> result = new HashMap<String, Object>();
     //   Person p = personService.findOne(1L);

        result.put("entity", personRepository.findAll());
        return  result;
    }
}
