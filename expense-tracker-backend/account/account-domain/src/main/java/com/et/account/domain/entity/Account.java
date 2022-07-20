package com.et.account.domain.entity;

import com.et.account.domain.valueObject.AccountType;
import com.et.common.domain.entity.AggregateRoot;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;
import com.et.common.domain.valueobject.UserId;

import java.util.UUID;

public class Account extends AggregateRoot<AccountId> {
    private final UserId userId;
    private String accountName;
    private AccountType accountType;
    private Currency accountCurrency;
    private Money accountBalance;


    public void createAccount(){
        setId(new AccountId(UUID.randomUUID()));
    }

    public void updateAccount(String accountName, AccountType accountType, Currency accountCurrency, Money accountBalance){
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountCurrency = accountCurrency;
        this.accountBalance = accountBalance;
    }

    public Money creditAccount(Money amount){
        this.accountBalance = this.accountBalance.add(amount);
        return this.accountBalance;
    }
    public Money debitAccount(Money amount){
        this.accountBalance = this.accountBalance.subtract(amount);
        return this.accountBalance;
    }

    private Account(Builder builder) {
        userId = builder.userId;
        accountName = builder.accountName;
        accountType = builder.accountType;
        accountCurrency = builder.accountCurrency;
        accountBalance = builder.accountBalance;
        super.setId(builder.accountId);
    }

    public static Builder builder() {
        return new Builder();
    }

    public UserId getUserId() {
        return userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Currency getAccountCurrency() {
        return accountCurrency;
    }

    public Money getAccountBalance() {
        return accountBalance;
    }


    public static final class Builder {
        private UserId userId;
        private String accountName;
        private AccountType accountType;
        private Currency accountCurrency;
        private Money accountBalance;
        private AccountId accountId;

        private Builder() {
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder accountName(String val) {
            accountName = val;
            return this;
        }

        public Builder accountType(AccountType val) {
            accountType = val;
            return this;
        }

        public Builder accountCurrency(Currency val) {
            accountCurrency = val;
            return this;
        }

        public Builder accountBalance(Money val) {
            accountBalance = val;
            return this;
        }

        public Builder accountId(AccountId val) {
            accountId = val;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
