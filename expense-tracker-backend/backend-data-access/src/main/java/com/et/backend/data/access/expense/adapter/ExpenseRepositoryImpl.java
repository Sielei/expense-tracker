package com.et.backend.data.access.expense.adapter;

import com.et.backend.data.access.expense.entity.CategoryEntity;
import com.et.backend.data.access.expense.mapper.ExpenseEntityDataMapper;
import com.et.backend.data.access.expense.entity.ExpenseEntity;
import com.et.backend.data.access.expense.repository.CategoryJpaRepository;
import com.et.backend.data.access.expense.repository.ExpenseJpaRepository;
import com.et.common.domain.valueobject.UserId;
import com.et.expense.application.service.mapper.ExpenseDataMapper;
import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import com.et.expense.domain.entity.Category;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.valueobject.CategoryId;
import com.et.expense.domain.valueobject.ExpenseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseJpaRepository expenseJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;
    private final ExpenseEntityDataMapper expenseDataMapper;
    @Override
    public Expense save(Expense expense) {
        ExpenseEntity expenseEntity = expenseDataMapper.expenseToExpenseEntity(expense);
        ExpenseEntity newExpenseEntity = expenseJpaRepository.save(expenseEntity);
        return expenseDataMapper.expenseEntityToExpense(newExpenseEntity);
    }

    @Override
    public Optional<Expense> findExpenseById(ExpenseId expenseId) {
        Optional<ExpenseEntity> expenseEntityOptional = expenseJpaRepository.findById(expenseId.getValue());
        return expenseEntityOptional.map(expenseDataMapper::expenseEntityToExpense);
    }

    @Override
    public List<Expense> findExpensesByUserId(UserId userId) {
        List<ExpenseEntity> expenseEntities = expenseJpaRepository.findByUserId(userId.getValue());
        return expenseEntities.stream()
                .map(expenseDataMapper::expenseEntityToExpense)
                .collect(Collectors.toList());
    }

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryToCategoryEntity = expenseDataMapper.categoryToCategoryEntity(category);
        CategoryEntity newCategoryEntity = categoryJpaRepository.save(categoryToCategoryEntity);
        return expenseDataMapper.categoryEntityToCategory(newCategoryEntity);
    }

    @Override
    public Optional<Category> findExpenseCategoryById(CategoryId categoryId) {
        Optional<CategoryEntity> categoryEntityOptional = categoryJpaRepository.findById(categoryId.getValue());
        return categoryEntityOptional.map(expenseDataMapper::categoryEntityToCategory);
    }

    @Override
    public List<Category> findAllUserCategories(UserId userId) {
        List<CategoryEntity> categoryEntityList = categoryJpaRepository.findByUserId(userId.getValue());
        return categoryEntityList.stream()
                .map(expenseDataMapper::categoryEntityToCategory)
                .collect(Collectors.toList());
    }
}
