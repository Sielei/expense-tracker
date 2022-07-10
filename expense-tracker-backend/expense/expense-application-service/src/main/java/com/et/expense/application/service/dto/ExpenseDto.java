package com.et.expense.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class ExpenseDto {

    private final String  userId;
    private final String expenseName;
    private final String expenseDescription;
    private final String categoryId;
    private final String  accountId;
    private final String currency;
    private final BigDecimal expenseCost;
}
