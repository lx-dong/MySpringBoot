package com.china317.myspringboot.entity.second;

import javax.persistence.*;

/**
 * Created by lx-dong on 2017/11/2.
 */
@Entity
@Table(name = "second")
public class Second {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
