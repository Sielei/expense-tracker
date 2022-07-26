package com.et.account.application.service.ports.input.helper;

import com.et.account.application.service.dto.AccountDto;
import com.et.account.application.service.mapper.AccountDataMapper;
import com.et.account.application.service.ports.output.repository.AccountRepository;
import com.et.account.domain.entity.Account;
import com.et.account.domain.service.AccountDomainService;
import com.et.account.domain.valueObject.AccountType;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateAccountHandler {

    private final AccountDomainService accountDomainService;
    private final AccountRepository accountRepository;
    private final AccountDataMapper accountDataMapper;

    @Transactional
    public AccountDto createAccount(AccountDto accountDto) {
        Account accountDtoToAccount = accountDataMapper.accountDtoToAccount(accountDto);
        accountDomainService.createAccount(accountDtoToAccount);
        Account newAccount = accountRepository.save(accountDtoToAccount);
        return accountDataMapper.accountToAccountDto(newAccount);
    }

    public AccountDto updateAccount(UUID accountId, AccountDto accountDto) {
        Account accountToUpdate = accountRepository.findAccountById(new AccountId(accountId)).get();
        accountDomainService.updateAccountDetails(accountToUpdate, accountDto.getAccountName(),
                AccountType.valueOf(accountDto.getAccountType()), Currency.valueOf(accountDto.getAccountCurrency()),
                new Money(accountDto.getAccountBalance()));
        accountRepository.updateAccount(accountToUpdate);
        return accountDataMapper.accountToAccountDto(accountToUpdate);

    }

    public void creditAccount(UUID accountId, BigDecimal amount) {
        Account accountToCredit = accountRepository.findAccountById(new AccountId(accountId)).get();
        accountDomainService.creditAccount(accountToCredit, new Money(amount));
        accountRepository.updateAccount(accountToCredit);
    }

    public void debitAccount(UUID accountId, BigDecimal amount) {
        Account accountToDebit = accountRepository.findAccountById(new AccountId(accountId)).get();
        accountDomainService.debitAccount(accountToDebit, new Money(amount));
        accountRepository.updateAccount(accountToDebit);
    }
}
