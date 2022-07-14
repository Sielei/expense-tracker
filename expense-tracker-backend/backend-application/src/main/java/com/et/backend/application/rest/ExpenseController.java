package com.et.backend.application.rest;

import com.et.expense.application.service.dto.ExpenseDto;
import com.et.expense.application.service.ports.input.service.ExpenseApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseApplicationService expenseApplicationService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto newExpenseDto = expenseApplicationService.createExpense(expenseDto);
        return new ResponseEntity<>(newExpenseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{expenseId}")
    public ResponseEntity<ExpenseDto> findExpenseById(@PathVariable("expenseId") UUID expenseId){
        ExpenseDto expenseDto = expenseApplicationService.findExpenseById(expenseId);
        return new ResponseEntity<>(expenseDto, HttpStatus.OK);
    }

    @GetMapping("/user-expenses/{userId}")
    public ResponseEntity<List<ExpenseDto>> findExpenseByUserId(@PathVariable("userId") UUID userId){
        List<ExpenseDto> expenseDtos = expenseApplicationService.findExpenseByUserId(userId);
        return new ResponseEntity<>(expenseDtos, HttpStatus.OK);
    }
}
