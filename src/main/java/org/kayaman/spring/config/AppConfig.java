package org.kayaman.spring.config;

import org.kayaman.spring.components.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Message getMessage() {
        return new Message();
    }
}
