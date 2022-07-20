package com.et.account.application.service.ports.input.service;

import com.et.account.application.service.dto.AccountDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountApplicationService {

    AccountDto createAccount(AccountDto accountDto);
    Optional<AccountDto> findAccountById(UUID accountId);
    List<AccountDto> findAllUserAccounts(UUID userId);
    AccountDto updateAccount(UUID accountId, AccountDto accountDto);
}
