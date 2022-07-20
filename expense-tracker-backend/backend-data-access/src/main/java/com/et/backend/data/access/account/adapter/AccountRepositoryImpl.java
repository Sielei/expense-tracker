package com.et.backend.data.access.account.adapter;

import com.et.account.application.service.ports.output.repository.AccountRepository;
import com.et.account.domain.entity.Account;
import com.et.account.domain.exception.AccountDomainException;
import com.et.backend.data.access.account.entity.AccountEntity;
import com.et.backend.data.access.account.mapper.AccountEntityDataMapper;
import com.et.backend.data.access.account.repository.AccountJpaRepository;
import com.et.common.domain.valueobject.AccountId;
import com.et.common.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;
    private final AccountEntityDataMapper accountEntityDataMapper;
    @Override
    public Account save(Account account) {
        AccountEntity accountToAccountEntity = accountEntityDataMapper.accountToAccountEntity(account);
        AccountEntity accountEntity = accountJpaRepository.save(accountToAccountEntity);
        return accountEntityDataMapper.accountEntityToAccount(accountEntity);
    }

    @Override
    public Optional<Account> findAccountById(AccountId accountId) {
        Optional<AccountEntity> accountEntityOptional = accountJpaRepository.findById(accountId.getValue());
        if (accountEntityOptional.isEmpty()){
            throw new AccountDomainException("Account with id: " + accountId.getValue() + " does not exist!");
        }
        return Optional.ofNullable(accountEntityDataMapper.accountEntityToAccount(accountEntityOptional.get()));
    }

    @Override
    public List<Account> findAllUserAccounts(UserId userId) {
        List<AccountEntity> accountEntityList = accountJpaRepository.findByUserId(userId.getValue());
        return accountEntityList.stream()
                .map(accountEntityDataMapper::accountEntityToAccount)
                .collect(Collectors.toList());
    }

    @Override
    public Account updateAccount(Account account) {
        AccountEntity accountEntityToUpdate = accountEntityDataMapper.accountToAccountEntity(account);
        AccountEntity accountEntity = accountJpaRepository.save(accountEntityToUpdate);
        return accountEntityDataMapper.accountEntityToAccount(accountEntity);
    }
}
