package com.devglan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Main Spring Boot application class with Hibernate 6 configuration.
 * Extended with ServletInitializer for WAR deployment.
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.devglan.dao")
@ComponentScan(basePackages = "com.devglan")
public class Application extends SpringBootServletInitializer {

    /**
     * Configuration for WAR deployment
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     * Main method that launches the Spring Boot application
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}