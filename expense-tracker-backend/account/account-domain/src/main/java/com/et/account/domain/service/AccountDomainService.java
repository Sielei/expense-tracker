package com.et.account.domain.service;

import com.et.account.domain.entity.Account;
import com.et.account.domain.valueObject.AccountType;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;

public interface AccountDomainService {

    void createAccount(Account account);
    void updateAccountDetails(Account account, String accountName, AccountType accountType, Currency accountCurrency, Money accountBalance);
    void creditAccount(Account account, Money amount);
    void debitAccount(Account account, Money amount);
}
