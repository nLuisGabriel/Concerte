package com.centersound.config.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;
@Configuration
@EnableJpaRepositories("com.centersound.repositories")
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterBean() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // determina daca browserul ar trebui sa includa un cookie asociat cu orice request
        // aduce pre-flight response si include Access-Control Allow-Credentials

        List<String> originsPatterns = new ArrayList<>();
        originsPatterns.add("http://localhost:4200");
        config.setAllowedOriginPatterns(originsPatterns);
        // ofera posibilitatea sa primeasca requesturi de la:
        // protocolul domeniul si port

        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        //requestmapping
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean =
                new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
