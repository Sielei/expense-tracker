package com.et.account.application.service.config;

import com.et.account.domain.service.AccountDomainService;
import com.et.account.domain.service.AccountDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountApplicationServiceConfig {

    @Bean
    public AccountDomainService accountDomainService(){
        return new AccountDomainServiceImpl();
    }
}
