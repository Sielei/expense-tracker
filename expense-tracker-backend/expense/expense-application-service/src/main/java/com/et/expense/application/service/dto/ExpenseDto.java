package com.et.expense.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ExpenseDto {

    private final String id;
    private final String  userId;
    private final String expenseName;
    private final String expenseDescription;
    private final String categoryId;
    private final String  accountId;
    private final String currency;
    private final BigDecimal expenseCost;
}
