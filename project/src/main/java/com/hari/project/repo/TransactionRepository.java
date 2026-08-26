package com.hari.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.project.entity.Transaction;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountId(Long accountId);

}