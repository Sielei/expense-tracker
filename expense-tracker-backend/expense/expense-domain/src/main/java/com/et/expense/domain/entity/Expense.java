package com.et.expense.domain.entity;

import com.et.common.domain.entity.AggregateRoot;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;
import com.et.common.domain.valueobject.UserId;
import com.et.expense.domain.valueobject.ExpenseId;

public class Expense extends AggregateRoot<ExpenseId> {

    private final UserId userId;
    private final String expenseName;
    private final String expenseDescription;
    private final Category category;
    private final AccountId accountId;
    private Currency currency;
    private final Money expenseCost;

    void createExpense(){}
    boolean isCostValid(){return true;}

    private Expense(Builder builder) {
        super.setId(builder.expenseId);
        userId = builder.userId;
        expenseName = builder.expenseName;
        expenseDescription = builder.expenseDescription;
        category = builder.category;
        accountId = builder.accountId;
        currency = builder.currency;
        expenseCost = builder.expenseCost;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public Category getCategory() {
        return category;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money getExpenseCost() {
        return expenseCost;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private ExpenseId expenseId;
        private UserId userId;
        private String expenseName;
        private String expenseDescription;
        private Category category;
        private AccountId accountId;
        private Currency currency;
        private Money expenseCost;

        private Builder() {
        }

        public Builder expenseId(ExpenseId val) {
            expenseId = val;
            return this;
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder expenseName(String val) {
            expenseName = val;
            return this;
        }

        public Builder expenseDescription(String val) {
            expenseDescription = val;
            return this;
        }

        public Builder category(Category val) {
            category = val;
            return this;
        }

        public Builder accountId(AccountId val) {
            accountId = val;
            return this;
        }

        public Builder currency(Currency val) {
            currency = val;
            return this;
        }

        public Builder expenseCost(Money val) {
            expenseCost = val;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }
}
