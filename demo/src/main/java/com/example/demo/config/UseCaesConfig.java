package com.example.demo.config;

import com.example.demo.client.PeopleClient;
import com.example.demo.service.PeopleService;
import com.example.demo.service.PeopleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaesConfig {
    @Bean
    public PeopleService peopleService(PeopleClient peopleClient) {
        return new PeopleServiceImpl(peopleClient);
    }
}
