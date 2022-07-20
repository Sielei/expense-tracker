package com.et.backend.data.access.account.mapper;

import com.et.account.domain.entity.Account;
import com.et.backend.data.access.account.entity.AccountEntity;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.Money;
import com.et.common.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

@Component
public class AccountEntityDataMapper {
    public AccountEntity accountToAccountEntity(Account account) {
        return AccountEntity.builder()
                .id(account.getId().getValue())
                .userId(account.getUserId().getValue())
                .accountName(account.getAccountName())
                .accountType(account.getAccountType())
                .accountCurrency(account.getAccountCurrency())
                .accountBalance(account.getAccountBalance().getAmount())
                .build();
    }

    public Account accountEntityToAccount(AccountEntity accountEntity) {
        return Account.builder()
                .accountId(new AccountId(accountEntity.getId()))
                .userId(new UserId(accountEntity.getUserId()))
                .accountName(accountEntity.getAccountName())
                .accountType(accountEntity.getAccountType())
                .accountCurrency(accountEntity.getAccountCurrency())
                .accountBalance(new Money(accountEntity.getAccountBalance()))
                .build();
    }
}
