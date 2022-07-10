package com.et.expense.domain.valueobject;

import com.et.common.domain.valueobject.BaseId;

import java.util.UUID;

public class ExpenseId extends BaseId<UUID> {
    public ExpenseId(UUID value) {
        super(value);
    }
}
