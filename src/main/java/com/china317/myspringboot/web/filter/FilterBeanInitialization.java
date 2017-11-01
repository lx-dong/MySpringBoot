package com.china317.myspringboot.web.filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by lx-dong on 2017/11/1.
 */
public class FilterBeanInitialization {
    @Bean
    public FilterRegistrationBean  userAuthenticationFilter(){
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(new UserAuthenticationFilter());
        register.setEnabled(true);
        register.setName("userAuthenticationFilter");
        return register;

    }
}
