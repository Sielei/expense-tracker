package com.et.expense.application.service.mapper;

import com.et.common.domain.valueobject.*;
import com.et.expense.application.service.dto.ExpenseCategoryDto;
import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.domain.entity.Category;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.valueobject.CategoryId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ExpenseDataMapper {

    public Expense expenseDtoToExpense(ExpenseDto expenseDto){
        return Expense
                .builder()
                .userId(new UserId(UUID.fromString(expenseDto.getUserId())))
                .accountId(new AccountId(UUID.fromString(expenseDto.getAccountId())))
                .category(Category.builder()
                        .categoryId(new CategoryId(UUID.fromString(expenseDto.getCategoryId())))
                        .build())
                .expenseName(expenseDto.getExpenseName())
                .expenseDescription(expenseDto.getExpenseDescription())
                .currency(Currency.valueOf(expenseDto.getCurrency()))
                .expenseStatus(null)
                .expenseCost(new Money(expenseDto.getExpenseCost()))
                .build();
    }

    public ExpenseDto expenseToExpenseDto(Expense expense) {
        return ExpenseDto
                .builder()
                .id(expense.getId().getValue().toString())
                .userId(expense.getUserId().getValue().toString())
                .accountId(expense.getAccountId().getValue().toString())
                .expenseName(expense.getExpenseName())
                .expenseDescription(expense.getExpenseDescription())
                .categoryId(expense.getCategory().getId().getValue().toString())
                .currency(expense.getCurrency().getValue())
                .expenseCost(expense.getExpenseCost().getAmount())
                .build();
    }

    public Category expenseCategoryDtoToCategory(ExpenseCategoryDto expenseCategoryDto) {
        return Category
                .builder()
                .userId(new UserId(UUID.fromString(expenseCategoryDto.getUserId())))
                .categoryName(expenseCategoryDto.getCategoryName())
                .categoryDescription(expenseCategoryDto.getCategoryDescription())
                .build();
    }

    public ExpenseCategoryDto categoryToCategoryExpenseDto(Category category) {
        return ExpenseCategoryDto.builder()
                .id(category.getId().getValue().toString())
                .userId(category.getUserId().getValue().toString())
                .categoryName(category.getCategoryName())
                .categoryDescription(category.getCategoryDescription())
                .build();
    }
}
