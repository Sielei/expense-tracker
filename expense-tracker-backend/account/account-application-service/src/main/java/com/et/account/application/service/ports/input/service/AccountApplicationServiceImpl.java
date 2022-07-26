package com.et.account.application.service.ports.input.service;

import com.et.account.application.service.dto.AccountDto;
import com.et.account.application.service.ports.input.helper.CreateAccountHandler;
import com.et.account.application.service.ports.input.helper.FetchAccountHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountApplicationServiceImpl implements AccountApplicationService{

    private final CreateAccountHandler createAccountHandler;
    private final FetchAccountHandler fetchAccountHandler;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        return createAccountHandler.createAccount(accountDto);
    }

    @Override
    public Optional<AccountDto> findAccountById(UUID accountId) {
        return fetchAccountHandler.findAccountById(accountId);
    }

    @Override
    public List<AccountDto> findAllUserAccounts(UUID userId) {
        return fetchAccountHandler.findAllUserAccounts(userId);
    }

    @Override
    public AccountDto updateAccount(UUID accountId, AccountDto accountDto) {
        return createAccountHandler.updateAccount(accountId, accountDto);
    }

    @Override
    public void creditAccount(UUID accountId, BigDecimal amount) {
        createAccountHandler.creditAccount(accountId, amount);
    }

    @Override
    public void debitAccount(UUID accountId, BigDecimal amount) {
        createAccountHandler.debitAccount(accountId, amount);
    }
}
