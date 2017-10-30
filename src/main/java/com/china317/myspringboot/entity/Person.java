package com.china317.myspringboot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lx-dong on 2017/10/27.
 */

@Entity
@Table(name="person")
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String sex;

    protected Person(){

    }
    public Person(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
