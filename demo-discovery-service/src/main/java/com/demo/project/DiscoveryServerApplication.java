package com.demo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Hello world!
 */
//@SpringBootApplication

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaServer

public class DiscoveryServerApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(DiscoveryServerApplication.class, args);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Eureka server had be up");
    }

    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
        }
    }

}
