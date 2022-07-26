package com.et.budget.domain.valueobject;

import com.et.common.domain.valueobject.BaseId;

import java.util.UUID;

public class BudgetId extends BaseId<UUID> {
    public BudgetId(UUID value) {
        super(value);
    }
}
