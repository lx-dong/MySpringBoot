package com.china317.myspringboot.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * Created by lx-dong on 2017/11/2.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.china317.myspringboot.repository.first"},
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager")
public class PrimaryConfig {
    @Autowired
    @Qualifier("primaryEntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory;

    @Primary
    @Bean
    public EntityManager primaryEntityManager(){
        return primaryEntityManagerFactory.getObject().createEntityManager();
    }


    @Primary
    @Bean
    public PlatformTransactionManager primaryTransactionManager(){
        return new JpaTransactionManager(primaryEntityManagerFactory.getObject());
    }
}
