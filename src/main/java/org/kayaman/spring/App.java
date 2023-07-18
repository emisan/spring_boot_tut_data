package org.kayaman.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application to present several integrations of java jdbc, Spring Data Jdbc, Spring Data JPA and
 * usage in a Spring project.
 * <blockquote>
 *     This application makes us of h2-database as in-memory database.<br>
 *     The application.properties have to be modified to set properties for a connection to a vendor RDMS database
 *     system, like MS SQL Server, as described by the vendor fro spring integrations.
 * </blockquote>
 *
 * @author Hayri Emrah Kayaman
 */
@SpringBootApplication
public class App
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
