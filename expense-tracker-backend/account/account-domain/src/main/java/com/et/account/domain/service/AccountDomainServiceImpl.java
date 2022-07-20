package com.et.account.domain.service;

import com.et.account.domain.entity.Account;
import com.et.account.domain.valueObject.AccountType;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;

public class AccountDomainServiceImpl implements AccountDomainService{
    @Override
    public void createAccount(Account account) {
        account.createAccount();
    }

    @Override
    public void updateAccountDetails(Account account, String accountName, AccountType accountType, Currency accountCurrency, Money accountBalance) {
        account.updateAccount(accountName, accountType, accountCurrency, accountBalance);
    }

    @Override
    public void creditAccount(Account account, Money amount) {
        account.creditAccount(amount);
    }

    @Override
    public void debitAccount(Account account, Money amount) {
        account.debitAccount(amount);
    }
}
