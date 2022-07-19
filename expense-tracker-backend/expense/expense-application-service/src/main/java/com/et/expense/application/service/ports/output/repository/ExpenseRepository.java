package com.et.expense.application.service.ports.output.repository;

import com.et.common.domain.valueobject.UserId;
import com.et.expense.domain.entity.Category;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.valueobject.CategoryId;
import com.et.expense.domain.valueobject.ExpenseId;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {

    Expense save(Expense expense);

    Optional<Expense> findExpenseById(ExpenseId expenseId);

    List<Expense> findExpensesByUserId(UserId userId);

    Category saveCategory(Category category);

    Optional<Category> findExpenseCategoryById(CategoryId categoryId);

    List<Category> findAllUserCategories(UserId userId);
}
