package com.et.backend.data.access.expense.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "expense_categories")
@Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class CategoryEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    private UUID userId;
    private String categoryName;
    private String categoryDescription;


}