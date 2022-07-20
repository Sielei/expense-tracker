package com.et.account.application.service.ports.input.helper;

import com.et.account.application.service.dto.AccountDto;
import com.et.account.application.service.mapper.AccountDataMapper;
import com.et.account.application.service.ports.output.repository.AccountRepository;
import com.et.account.domain.entity.Account;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FetchAccountHandler {

    private final AccountRepository accountRepository;
    private final AccountDataMapper accountDataMapper;
    public Optional<AccountDto> findAccountById(UUID accountId) {
        Optional<Account> accountOptional = accountRepository.findAccountById(new AccountId(accountId));
        return Optional.ofNullable(accountDataMapper.accountToAccountDto(accountOptional.get()));
    }

    public List<AccountDto> findAllUserAccounts(UUID userId) {
        List<Account> accountList = accountRepository.findAllUserAccounts(new UserId(userId));
        return accountList.stream()
                .map(accountDataMapper::accountToAccountDto)
                .collect(Collectors.toList());
    }
}
