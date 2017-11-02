package com.china317.myspringboot.web.filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lx-dong on 2017/11/1.
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean  userAuthenticationFilter(){
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(new UserAuthenticationFilter());
        register.setEnabled(true);
        register.setName("userAuthenticationFilter");
        register.addUrlPatterns("/*");
        register.addInitParameter("targetFilterLifecycle","true");
        register.setOrder(1);
        return register;
    }


}
