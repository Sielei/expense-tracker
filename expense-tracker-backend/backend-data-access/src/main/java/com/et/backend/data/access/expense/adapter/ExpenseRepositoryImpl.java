package com.et.backend.data.access.expense.adapter;

import com.et.backend.data.access.expense.entity.ExpenseEntity;
import com.et.backend.data.access.expense.repository.ExpenseJpaRepository;
import com.et.common.domain.valueobject.UserId;
import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.valueobject.ExpenseId;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {

    private final ExpenseJpaRepository expenseJpaRepository;
    private final ModelMapper modelMapper;
    @Override
    public Expense save(Expense expense) {
        ExpenseEntity newExpenseEntity = expenseJpaRepository.save(modelMapper.map(expense, ExpenseEntity.class));
        return modelMapper.map(newExpenseEntity, Expense.class);
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
