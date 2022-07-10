package com.et.expense.application.service.ports.input.handler;

import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.mapper.ExpenseDataMapper;
import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import com.et.expense.domain.entity.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreateExpenseHandler {

    private final ExpenseDataMapper expenseDataMapper;
    private final ExpenseRepository expenseRepository;
    @Transactional
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseDataMapper.expenseDtoToExpense(expenseDto);
        Expense newExpense = expenseRepository.save(expense);
        return expenseDataMapper.expenseToExpenseDto(newExpense);
    }
}
