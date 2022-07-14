package com.et.expense.application.service.ports.input.handler;

import com.et.common.domain.valueobject.UserId;
import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.mapper.ExpenseDataMapper;
import com.et.expense.application.service.ports.output.repository.ExpenseRepository;
import com.et.expense.domain.entity.Expense;
import com.et.expense.domain.exception.ExpenseDomainException;
import com.et.expense.domain.service.ExpenseDomainService;
import com.et.expense.domain.valueobject.ExpenseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FetchExpenseHandler {

    private final ExpenseDataMapper expenseDataMapper;
    private final ExpenseRepository expenseRepository;
    private final ExpenseDomainService expenseDomainService;
    public ExpenseDto findExpenseById(UUID expenseId) {
        Optional<Expense> expenseOptional = expenseRepository.findExpenseById(new ExpenseId(expenseId));
        if (expenseOptional.isEmpty()){
            throw new ExpenseDomainException("Expense with id: " + expenseId + " does not exist.");
        }
        Expense expense = expenseOptional.get();
        return expenseDataMapper.expenseToExpenseDto(expense);
    }

    public List<ExpenseDto> findByUserId(UUID userId) {
        List<Expense> expenses = expenseRepository.findExpensesByUserId(new UserId(userId));
        return expenses.stream()
                .map(expenseDataMapper::expenseToExpenseDto)
                .collect(Collectors.toList());
    }
}
