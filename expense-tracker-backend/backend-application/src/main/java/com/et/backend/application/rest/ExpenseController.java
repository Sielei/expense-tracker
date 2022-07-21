package com.et.backend.application.rest;

import com.et.expense.application.service.dto.ExpenseCategoryDto;
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
    public ResponseEntity<ExpenseDto> createExpense(@RequestAttribute("userId") UUID userId, @RequestBody ExpenseDto expenseDto){
        expenseDto.setUserId(userId.toString());
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

    @PostMapping("/categories")
    public ResponseEntity<ExpenseCategoryDto> createExpenseCategory(@RequestAttribute("userId") UUID userId, @RequestBody ExpenseCategoryDto categoryDto){
        categoryDto.setUserId(userId.toString());
        ExpenseCategoryDto expenseCategoryDto = expenseApplicationService.createExpenseCategory(categoryDto);
        return new ResponseEntity<>(expenseCategoryDto, HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ExpenseCategoryDto>> findExpenseCategories(@RequestAttribute("userId") UUID userId){
        List<ExpenseCategoryDto> expenseCategoryDtoList = expenseApplicationService.findAllUserExpenseCategories(userId);
        return new ResponseEntity<>(expenseCategoryDtoList, HttpStatus.OK);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<ExpenseCategoryDto> findExpenseCategoryById(@PathVariable("categoryId") UUID categoryId){
        ExpenseCategoryDto expenseCategoryDto = expenseApplicationService.findExpenseCategoryById(categoryId);
        return new ResponseEntity<>(expenseCategoryDto, HttpStatus.OK);
    }


}
