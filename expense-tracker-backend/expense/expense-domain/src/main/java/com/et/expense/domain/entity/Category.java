package com.et.expense.domain.entity;

import com.et.common.domain.entity.BaseEntity;
import com.et.common.domain.valueobject.UserId;
import com.et.expense.domain.valueobject.CategoryId;

public class Category extends BaseEntity<CategoryId> {

    private String categoryName;
    private String categoryDescription;

    public Category(UserId userId, CategoryId categoryId, String categoryName, String categoryDescription){
        super.setId(categoryId);
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Category(CategoryId categoryId){
        super.setId(categoryId);
    }

    public void updateCategoryWithNameAndDescription(String categoryName, String categoryDescription){
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }
}
