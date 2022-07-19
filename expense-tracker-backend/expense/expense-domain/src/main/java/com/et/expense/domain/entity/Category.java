package com.et.expense.domain.entity;

import com.et.common.domain.entity.BaseEntity;
import com.et.common.domain.valueobject.UserId;
import com.et.expense.domain.valueobject.CategoryId;

import java.util.UUID;

public class Category extends BaseEntity<CategoryId> {

    private final UserId userId;
    private String categoryName;
    private String categoryDescription;


    private Category(Builder builder) {
        super.setId(builder.categoryId);
        userId = builder.userId;
        categoryName = builder.categoryName;
        categoryDescription = builder.categoryDescription;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void createCategory(){
        setId(new CategoryId(UUID.randomUUID()));
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

    public UserId getUserId() {
        return userId;
    }


    public static final class Builder {
        private CategoryId categoryId;
        private UserId userId;
        private String categoryName;
        private String categoryDescription;

        private Builder() {
        }

        public Builder categoryId(CategoryId val) {
            categoryId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder categoryName(String val) {
            categoryName = val;
            return this;
        }

        public Builder categoryDescription(String val) {
            categoryDescription = val;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
