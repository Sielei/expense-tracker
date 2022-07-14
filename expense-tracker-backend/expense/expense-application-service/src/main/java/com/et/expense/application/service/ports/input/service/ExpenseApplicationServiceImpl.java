package com.et.expense.application.service.ports.input.service;

import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.ports.input.handler.CreateExpenseHandler;
import com.et.expense.application.service.ports.input.handler.FetchExpenseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseApplicationServiceImpl implements ExpenseApplicationService{

    private final CreateExpenseHandler createExpenseHandler;
    private final FetchExpenseHandler fetchExpenseHandler;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        return createExpenseHandler.createExpense(expenseDto);
    }

    @Override
    public ExpenseDto findExpenseById(UUID expenseId) {
        return fetchExpenseHandler.findExpenseById(expenseId);
    }

    @Override
    public List<ExpenseDto> findExpenseByUserId(UUID userId) {
        return fetchExpenseHandler.findByUserId(userId);
    }
}
