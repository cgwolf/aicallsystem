package com.aicallsystem.acs.config;

import com.aicallsystem.acs.filter.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Autowired
    private TokenFilter tokenFilter;

    @Bean
    public FilterRegistrationBean tokenFilterConfig(){

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(tokenFilter);
        String[] filterPath = {
                "/contact/deleteContact",
                "/contact/listContact",
                "/contact/updateContactState",
                "/test/*"
        };
        registration.addUrlPatterns(filterPath);
        registration.setName("TokenFilter");
        registration.setOrder(1);
        return registration;
    }

}
