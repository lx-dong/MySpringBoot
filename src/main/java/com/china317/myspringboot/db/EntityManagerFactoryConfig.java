package com.china317.myspringboot.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by lx-dong on 2017/11/2.
 */
@Configuration
public class EntityManagerFactoryConfig {


    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource){
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Autowired
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory
            (EntityManagerFactoryBuilder builder, @Qualifier("primaryDataSource")DataSource primaryDataSource){
        return builder
                .dataSource(primaryDataSource)
                .packages("com.china317.myspringboot.entity.first")
                .persistenceUnit("first")
                .properties(getVendorProperties(primaryDataSource))
                .build();
    }

    @Autowired
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory
            (EntityManagerFactoryBuilder builder, @Qualifier("secondDataSource")DataSource secondDataSource){
        return builder
                .dataSource(secondDataSource)
                .packages("com.china317.myspringboot.entity.first")
                .persistenceUnit("second")
                .properties(getVendorProperties(secondDataSource))
                .build();

    }


}
