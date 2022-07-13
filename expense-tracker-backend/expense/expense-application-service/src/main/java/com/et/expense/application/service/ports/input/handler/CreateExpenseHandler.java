package com.et.expense.application.service.ports.input.handler;

import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.mapper.ExpenseDataMapper;
import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.service.ExpenseDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateExpenseHandler {

    private final ExpenseDataMapper expenseDataMapper;
    private final ExpenseRepository expenseRepository;
    private final ExpenseDomainService expenseDomainService;
    @Transactional
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseDataMapper.expenseDtoToExpense(expenseDto);
        expenseDomainService.initializeAndInitializeExpense(expense);
        Expense newExpense = expenseRepository.save(expense);
        return expenseDataMapper.expenseToExpenseDto(newExpense);
    }
}
