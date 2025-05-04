/**
 * Main Spring Boot application class that serves as the entry point for the application.
 * The @SpringBootApplication annotation enables:
 * - Auto-configuration (sets up default configuration based on dependencies)
 * - Component scanning (automatically discovers beans in the application context)
 * - Spring Configuration (allows importing additional configuration classes)
 */
package com.devglan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /**
     * Main method that launches the Spring Boot application.
     * 
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        // Bootstraps the Spring application context, starting the application
        SpringApplication.run(Application.class, args);
    }
}