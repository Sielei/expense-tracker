package com.et.expense.application.service.ports.input.service;

import com.et.expense.application.service.dto.ExpenseDto;

import java.util.List;
import java.util.UUID;

public interface ExpenseApplicationService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto findExpenseById(UUID expenseId);

    List<ExpenseDto> findExpenseByUserId(UUID userId);
}
