package com.et.expense.application.service.dto;

import lombok.*;

import java.math.BigDecimal;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ExpenseDto {

    private String id;
    private String  userId;
    private String expenseName;
    private String expenseDescription;
    private String categoryId;
    private String  accountId;
    private String currency;
    private BigDecimal expenseCost;
}
