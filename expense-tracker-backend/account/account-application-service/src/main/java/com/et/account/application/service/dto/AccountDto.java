package com.et.account.application.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AccountDto {
    private String accountId;
    private String  userId;
    private String accountName;
    private String accountType;
    private String  accountCurrency;
    private BigDecimal accountBalance;
}
