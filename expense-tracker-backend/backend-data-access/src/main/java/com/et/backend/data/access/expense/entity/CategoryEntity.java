package com.et.backend.data.access.expense.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "expense_categories")
public class CategoryEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    private String categoryName;
    private String categoryDescription;


}