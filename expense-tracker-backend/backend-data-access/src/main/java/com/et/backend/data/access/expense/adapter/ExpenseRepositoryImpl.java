package com.et.backend.data.access.expense.adapter;

import com.et.backend.data.access.expense.mapper.ExpenseEntityDataMapper;
import com.et.backend.data.access.expense.entity.ExpenseEntity;
import com.et.backend.data.access.expense.repository.ExpenseJpaRepository;
import com.et.common.domain.valueobject.UserId;
import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.valueobject.ExpenseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseJpaRepository expenseJpaRepository;
    private final ExpenseEntityDataMapper expenseDataMapper;
    @Override
    public Expense save(Expense expense) {
        ExpenseEntity expenseEntity = expenseDataMapper.expenseToExpenseEntity(expense);
        ExpenseEntity newExpenseEntity = expenseJpaRepository.save(expenseEntity);
        return expenseDataMapper.expenseEntityToExpense(newExpenseEntity);
    }

    @Override
    public Optional<Expense> findExpenseById(ExpenseId expenseId) {
        return Optional.empty();
    }

    @Override
    public List<Expense> findExpensesByUserId(UserId userId) {
        return null;
    }
}
