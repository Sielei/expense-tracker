package com.et.expense.application.service.ports.input.service;

import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.ports.input.handler.CreateExpenseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseApplicationServiceImpl implements ExpenseApplicationService{

    private final CreateExpenseHandler createExpenseHandler;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        return createExpenseHandler.createExpense(expenseDto);
    }
}
