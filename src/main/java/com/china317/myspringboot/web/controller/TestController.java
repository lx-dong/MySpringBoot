package com.china317.myspringboot.web.controller;

import com.china317.myspringboot.entity.first.Person;
import com.china317.myspringboot.entity.second.Second;
import com.china317.myspringboot.repository.first.PersonDao;
import com.china317.myspringboot.repository.second.SecondDao;
import com.china317.myspringboot.service.PersonService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    PersonDao personDao;
    @Autowired
    SecondDao secondDao;

    @RequestMapping("/index")
    public JsonNode helloWorld(HttpServletRequest request, @ModelAttribute("attAdd") String attAdd){
        System.out.println("/index enter. attAdd=" + attAdd);

        ObjectNode result = new ObjectMapper().createObjectNode();
        result.put("msg", "Hello World!");
        return result;
    }

    @RequestMapping("/save")
    public Map<String, Object> save(){
        System.out.println("/save enter");
        Person p = new Person("小明", "man");
        Person p2 = personService.save(p);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("entity", p2);
        return result;
    }

    @RequestMapping("/find")
    public Map<String, Object> find(){
        System.out.println("/find enter");
        Map<String, Object> result = new HashMap<String, Object>();
     //   Person p = personService.findOne(1L);

        result.put("entity", personDao.findAll());
        return  result;
    }

    @RequestMapping("/doError")
    public void doError() throws Exception {
        throw new Exception("my error");
    }

    @RequestMapping("/saveSecond")
    public Second saveSecond(){
        Second s = new Second();
        s.setName("second");
        s.setValue("2");
        return secondDao.save(s);
    }

    @RequestMapping("/listSecond")
    public Object listSecond(){
        return secondDao.findAll();
    }
}
