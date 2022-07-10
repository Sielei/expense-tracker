package com.et.expense.application.service.ports.input.service;

import com.et.expense.application.service.dto.ExpenseDto;

public interface ExpenseApplicationService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

}
