package com.aicallsystem.acs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *      跨域配置
 * </p>
 * @author ispong
 * @since 4/4/2019
 * @version 1.0.0
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/acs/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowCredentials(true).maxAge(3600);

    }



}
