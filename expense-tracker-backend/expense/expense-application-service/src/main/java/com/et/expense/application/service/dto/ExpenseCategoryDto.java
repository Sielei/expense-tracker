package com.et.expense.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ExpenseCategoryDto {
    private String id;
    private String userId;
    private String categoryName;
    private String categoryDescription;
}
