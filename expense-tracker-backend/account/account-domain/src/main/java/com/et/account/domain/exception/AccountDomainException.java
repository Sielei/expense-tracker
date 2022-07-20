package com.et.account.domain.exception;

import com.et.common.domain.exception.DomainException;

public class AccountDomainException extends DomainException {
    public AccountDomainException(String message) {
        super(message);
    }

    public AccountDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
