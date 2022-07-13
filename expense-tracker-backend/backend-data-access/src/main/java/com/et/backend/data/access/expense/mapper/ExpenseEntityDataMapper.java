package com.et.backend.data.access.expense.mapper;

import com.et.backend.data.access.expense.entity.CategoryEntity;
import com.et.backend.data.access.expense.entity.ExpenseEntity;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.Money;
import com.et.common.domain.valueobject.UserId;
import com.et.expense.domain.entity.Category;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.valueobject.CategoryId;
import com.et.expense.domain.valueobject.ExpenseId;
import org.springframework.stereotype.Component;

@Component
public class ExpenseEntityDataMapper {
    public ExpenseEntity expenseToExpenseEntity(Expense expense) {
        Category category = expense.getCategory();
        CategoryEntity categoryEntity = CategoryEntity
                .builder()
                .id(category.getId().getValue())
                .userId(expense.getUserId().getValue())
                .categoryName(category.getCategoryName())
                .categoryDescription(category.getCategoryDescription())
                .build();
        return ExpenseEntity
                .builder()
                .id(expense.getId().getValue())
                .userId(expense.getUserId().getValue())
                .accountId(expense.getAccountId().getValue())
                .expenseName(expense.getExpenseName())
                .expenseDescription(expense.getExpenseDescription())
                .category(categoryEntity)
                .currency(expense.getCurrency())
                .expenseCost(expense.getExpenseCost().getAmount())
                .expenseStatus(expense.getExpenseStatus())
                .build();
    }

    public Expense expenseEntityToExpense(ExpenseEntity expenseEntity) {
        return Expense
                .builder()
                .expenseId(new ExpenseId(expenseEntity.getId()))
                .userId(new UserId(expenseEntity.getUserId()))
                .accountId(new AccountId(expenseEntity.getAccountId()))
                .expenseName(expenseEntity.getExpenseName())
                .expenseDescription(expenseEntity.getExpenseDescription())
                .category(categoryEntityToCategory(expenseEntity.getCategory()))
                .currency(expenseEntity.getCurrency())
                .expenseCost(new Money(expenseEntity.getExpenseCost()))
                .expenseStatus(expenseEntity.getExpenseStatus())
                .build();
    }

    private Category categoryEntityToCategory(CategoryEntity categoryEntity) {
        return new Category(new UserId(categoryEntity.getUserId()), new CategoryId(categoryEntity.getId()),
                categoryEntity.getCategoryName(), categoryEntity.getCategoryDescription());
    }
}
