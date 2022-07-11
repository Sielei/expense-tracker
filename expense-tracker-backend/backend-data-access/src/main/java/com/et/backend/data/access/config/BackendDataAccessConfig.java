package com.et.backend.data.access.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendDataAccessConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
