package com.et.backend.data.access.expense.repository;

import com.et.backend.data.access.expense.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseJpaRepository extends JpaRepository<ExpenseEntity, UUID> {
}
