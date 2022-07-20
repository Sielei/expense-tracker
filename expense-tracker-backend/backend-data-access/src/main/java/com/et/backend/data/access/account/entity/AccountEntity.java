package com.et.backend.data.access.account.entity;

import com.et.account.domain.valueObject.AccountType;
import com.et.common.domain.valueobject.Currency;
import com.et.common.domain.valueobject.Money;
import com.et.common.domain.valueobject.UserId;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class AccountEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    private UUID userId;
    private String accountName;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Enumerated(EnumType.STRING)
    private Currency accountCurrency;
    private BigDecimal accountBalance;

}