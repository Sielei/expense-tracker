package com.et.expense.application.service.ports.input.service;

import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.et")
public class ExpenseTestConfiguration {

    @Bean
    ExpenseRepository expenseRepository(){
        return Mockito.mock(ExpenseRepository.class);
    }
}
