package com.swapi.app.config;

import com.swapi.app.client.PeopleClient;
import com.swapi.app.service.PeopleService;
import com.swapi.app.service.impl.PeopleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaesConfig {
    @Bean
    public PeopleService peopleService(PeopleClient peopleClient) {
        return new PeopleServiceImpl(peopleClient);
    }
}
