package com.et.backend.application.rest;

import com.et.account.application.service.dto.AccountDto;
import com.et.account.application.service.ports.input.service.AccountApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountApplicationService accountApplicationService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestAttribute("userId") UUID userId, @RequestBody AccountDto accountDto){
        accountDto.setUserId(userId.toString());
        AccountDto newAccount = accountApplicationService.createAccount(accountDto);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable("accountId") UUID accountId){
        AccountDto accountDto = accountApplicationService.findAccountById(accountId).get();
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountDto> updateAccountDetails(@PathVariable("accountId") UUID accountId,
                                                       @RequestBody AccountDto accountDto){
        AccountDto updatedAccount = accountApplicationService.updateAccount(accountId, accountDto);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> findAllUserAccounts(@RequestAttribute("userId") UUID userId){
        List<AccountDto> accountDtoList = accountApplicationService.findAllUserAccounts(userId);
        return new ResponseEntity<>(accountDtoList, HttpStatus.OK);
    }
}
