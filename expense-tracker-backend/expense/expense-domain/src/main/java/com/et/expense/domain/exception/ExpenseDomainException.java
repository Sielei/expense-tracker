package com.et.expense.domain.exception;

import com.et.common.domain.exception.DomainException;

public class ExpenseDomainException extends DomainException {
    public ExpenseDomainException(String message) {
        super(message);
    }

    public ExpenseDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
