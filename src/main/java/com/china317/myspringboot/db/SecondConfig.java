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

/**
 * Created by lx-dong on 2017/11/2.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.china317.myspringboot.repository.second"},
        entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager")
public class SecondConfig {
    @Autowired
    @Qualifier("secondEntityManagerFactory")
    private LocalContainerEntityManagerFactoryBean secondEntityManagerFactory;

    @Bean
    public EntityManager secondEntityManager(){
        return secondEntityManagerFactory.getObject().createEntityManager();
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager(){
        return new JpaTransactionManager(secondEntityManagerFactory.getObject());
    }
}
