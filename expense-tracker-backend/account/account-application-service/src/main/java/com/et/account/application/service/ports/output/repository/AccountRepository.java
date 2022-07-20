package com.et.account.application.service.ports.output.repository;

import com.et.account.domain.entity.Account;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.UserId;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);
    Optional<Account> findAccountById(AccountId accountId);
    List<Account> findAllUserAccounts(UserId userId);
    Account updateAccount(Account account);
}
