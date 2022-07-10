package com.et.common.domain.valueobject;

import java.util.UUID;

public class AccountId extends BaseId<UUID> {
    public AccountId(UUID value) {
        super(value);
    }
}
