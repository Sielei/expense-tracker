package com.et.expense.domain.service;

import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;
import com.et.expense.domain.entity.Category;
import com.et.expense.domain.entity.Expense;

public interface ExpenseDomainService {
    void initializeAndValidateExpense(Expense expense);

    void updateExpense(Expense expense, String expenseName, String expenseDescription, Category category,
                       AccountId accountId, Currency currency, Money expenseCost);

    void deleteExpense(Expense expense);


    void initAndCreateCategory(Category category);
}
