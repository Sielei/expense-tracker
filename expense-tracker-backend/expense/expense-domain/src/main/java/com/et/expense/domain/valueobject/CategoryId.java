package com.et.expense.domain.valueobject;

import com.et.common.domain.valueobject.BaseId;

import java.util.UUID;

public class CategoryId extends BaseId<UUID> {
    public CategoryId(UUID value) {
        super(value);
    }
}
