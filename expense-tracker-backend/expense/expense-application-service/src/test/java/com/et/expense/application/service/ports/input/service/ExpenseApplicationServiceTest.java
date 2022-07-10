package com.et.expense.application.service.ports.input.service;

import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.mapper.ExpenseDataMapper;
import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import com.et.expense.domain.entity.Expense;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = ExpenseTestConfiguration.class)
class ExpenseApplicationServiceTest {

    @Autowired
    private ExpenseApplicationService expenseApplicationService;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseDataMapper expenseDataMapper;

    private ExpenseDto expenseDto;


    @BeforeAll
    void init(){
        expenseDto = ExpenseDto
                .builder()
                .userId("d215b5f8-0249-4dc5-89a3-51fd148cfb41")
                .accountId("d215b5f8-0249-4dc5-89a3-51fd148cfb45")
                .categoryId("d215b5f8-0249-4dc5-89a3-51fd148cfb48")
                .expenseName("Grocery Shopping")
                .expenseDescription("Grocery Shopping")
                .currency("KES")
                .expenseCost(new BigDecimal("300.00"))
                .build();

        Expense expense = expenseDataMapper.expenseDtoToExpense(expenseDto);

        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);
    }

    @Test
    public void testCreateExpense(){
        ExpenseDto newExpense = expenseApplicationService.createExpense(expenseDto);
        assertNotNull(newExpense);
        assertEquals(newExpense.getExpenseName(), "Grocery Shopping");
    }

}