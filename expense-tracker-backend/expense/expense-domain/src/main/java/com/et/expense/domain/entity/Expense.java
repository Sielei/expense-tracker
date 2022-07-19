package com.et.expense.domain.entity;

import com.et.common.domain.entity.AggregateRoot;
import com.et.common.domain.valueobject.*;
import com.et.expense.domain.exception.ExpenseDomainException;
import com.et.expense.domain.valueobject.ExpenseId;

import java.util.UUID;

public class Expense extends AggregateRoot<ExpenseId> {

    private final UserId userId;
    private String expenseName;
    private String expenseDescription;
    private Category category;
    private AccountId accountId;
    private Currency currency;
    private Money expenseCost;
    private ExpenseStatus expenseStatus;

    public void createExpense(){
        setId(new ExpenseId(UUID.randomUUID()));
        validateExpense();
        validateExpenseCost();
        expenseStatus = ExpenseStatus.CREATED;

    }

    public void updateExpense(String expenseName, String expenseDescription,Category category,
                              AccountId accountId, Currency currency, Money expenseCost){
        this.expenseName = expenseName;
        this.expenseDescription = expenseDescription;
        this.category = category;
        this.accountId = accountId;
        this.currency = currency;
        this.expenseCost = expenseCost;
    }


    private void validateExpenseCost() {
        if (!isCostValid()){
            throw new ExpenseDomainException("Expense cost should be greater than zero!");
        }
    }

    private void validateExpense() {
        if (expenseStatus != null && getId() != null){
            throw new ExpenseDomainException("Expense is not in valid initial state!");
        }
    }

    public void deleteExpense(){
        expenseStatus = ExpenseStatus.DELETED;
    }
    boolean isCostValid(){return expenseCost != null && expenseCost.isGreaterThanZero();}

    private Expense(Builder builder) {
        super.setId(builder.expenseId);
        userId = builder.userId;
        expenseName = builder.expenseName;
        expenseDescription = builder.expenseDescription;
        category = builder.category;
        accountId = builder.accountId;
        currency = builder.currency;
        expenseCost = builder.expenseCost;
        expenseStatus = builder.expenseStatus;
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

    public ExpenseStatus getExpenseStatus() {
        return expenseStatus;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        public ExpenseStatus expenseStatus;
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

        public Builder expenseStatus(ExpenseStatus val){
            expenseStatus = val;
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
