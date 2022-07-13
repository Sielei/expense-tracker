package com.et.backend.data.access.expense.entity;

import com.et.common.domain.valueobject.*;
import com.et.expense.domain.entity.Category;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "expenses")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ExpenseEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    private UUID userId;
    private UUID accountId;
    private String expenseName;
    private String expenseDescription;

    @OneToOne
    private CategoryEntity category;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private BigDecimal expenseCost;
    @Enumerated(EnumType.STRING)
    private ExpenseStatus expenseStatus;
}