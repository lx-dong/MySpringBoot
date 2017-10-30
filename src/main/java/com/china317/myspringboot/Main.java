package com.china317.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by lx-dong on 2017/10/27.
 */
@EnableTransactionManagement
@SpringBootApplication
//@EntityScan(basePackages = {"com.china317.myspringboot.entity"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
