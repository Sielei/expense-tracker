package com.et.expense.domain.service;

import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;
import com.et.expense.domain.entity.Category;
import com.et.expense.domain.entity.Expense;

public class ExpenseDomainServiceImpl implements ExpenseDomainService{
    @Override
    public void initializeAndInitializeExpense(Expense expense) {
        expense.createExpense();
    }

    @Override
    public void updateExpense(Expense expense, String expenseName, String expenseDescription, Category category,
                              AccountId accountId, Currency currency, Money expenseCost) {
        expense.updateExpense(expenseName, expenseDescription, category, accountId, currency, expenseCost);
    }

    @Override
    public void deleteExpense(Expense expense) {
        expense.deleteExpense();
    }

    @Override
    public void initAndCreateCategory(Category category) {
        category.createCategory();
    }
}
