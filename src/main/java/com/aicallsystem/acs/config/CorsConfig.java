package com.aicallsystem.acs.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>
 *      跨域配置
 * </p>
 * @author ispong
 * @since 4/4/2019
 * @version 1.0.0
 */
@Configuration
public class CorsConfig {

    /**
     * <p>
     *     配置跨域过滤器
     * </p>
     * @since 4/8/2019
     */
    @Bean
    public FilterRegistrationBean corsFilter(){

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter(source));
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;

    }

}
