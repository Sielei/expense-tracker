package com.et.backend.application.rest;

import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.ports.input.service.ExpenseApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private ExpenseApplicationService expenseApplicationService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto newExpenseDto = expenseApplicationService.createExpense(expenseDto);
        return new ResponseEntity<>(newExpenseDto, HttpStatus.CREATED);
    }
}
