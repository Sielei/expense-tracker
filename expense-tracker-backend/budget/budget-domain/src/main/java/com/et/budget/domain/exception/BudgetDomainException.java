package com.et.budget.domain.exception;

import com.et.common.domain.exception.DomainException;

public class BudgetDomainException extends DomainException {
    public BudgetDomainException(String message) {
        super(message);
    }

    public BudgetDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
