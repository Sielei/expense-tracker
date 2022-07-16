package com.et.user.domain.exception;

import com.et.common.domain.exception.DomainException;

public class UserDomainException extends DomainException {
    public UserDomainException(String message) {
        super(message);
    }

    public UserDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
