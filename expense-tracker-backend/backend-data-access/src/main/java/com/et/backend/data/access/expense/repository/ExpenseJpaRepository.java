package com.et.backend.data.access.expense.repository;

import com.et.backend.data.access.expense.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseJpaRepository extends JpaRepository<ExpenseEntity, UUID> {
    List<ExpenseEntity> findByUserId(UUID value);
}
