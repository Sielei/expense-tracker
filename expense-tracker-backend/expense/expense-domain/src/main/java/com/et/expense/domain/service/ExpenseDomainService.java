package com.et.expense.domain.service;

import com.et.expense.domain.entity.Expense;

public interface ExpenseDomainService {
    void initializeAndInitializeExpense(Expense expense);

    void updateExpense(Expense expense);

    void deleteExpense(Expense expense);
}
