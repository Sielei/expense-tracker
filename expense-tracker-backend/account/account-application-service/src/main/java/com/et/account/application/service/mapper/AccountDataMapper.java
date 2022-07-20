package com.et.account.application.service.mapper;

import com.et.account.application.service.dto.AccountDto;
import com.et.account.domain.entity.Account;
import com.et.account.domain.valueObject.AccountType;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;
import com.et.common.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountDataMapper {
    public Account accountDtoToAccount(AccountDto accountDto) {
        return Account.builder()
                .userId(new UserId(UUID.fromString(accountDto.getUserId())))
                .accountName(accountDto.getAccountName())
                .accountType(AccountType.valueOf(accountDto.getAccountType()))
                .accountCurrency(Currency.valueOf(accountDto.getAccountCurrency()))
                .accountBalance(new Money(accountDto.getAccountBalance()))
                .build();
    }

    public AccountDto accountToAccountDto(Account account) {
        return AccountDto.builder()
                .accountId(account.getId().getValue().toString())
                .userId(account.getUserId().getValue().toString())
                .accountName(account.getAccountName())
                .accountType(account.getAccountType().toString())
                .accountCurrency(account.getAccountCurrency().getValue())
                .accountBalance(account.getAccountBalance().getAmount())
                .build();
    }
}
