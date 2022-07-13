package com.et.expense.application.service.config;

import com.et.expense.domain.service.ExpenseDomainService;
import com.et.expense.domain.service.ExpenseDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpenseApplicationServiceConfig {

    @Bean
    public ExpenseDomainService expenseDomainService(){
        return new ExpenseDomainServiceImpl();
    }
}
