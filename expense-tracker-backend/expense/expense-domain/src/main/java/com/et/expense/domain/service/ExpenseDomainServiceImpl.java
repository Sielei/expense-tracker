package com.et.expense.domain.service;

import com.et.expense.domain.entity.Expense;

public class ExpenseDomainServiceImpl implements ExpenseDomainService{
    @Override
    public void initializeAndInitializeExpense(Expense expense) {
        expense.createExpense();
    }

    @Override
    public void updateExpense(Expense expense) {
    }

    @Override
    public void deleteExpense(Expense expense) {
    }
}
