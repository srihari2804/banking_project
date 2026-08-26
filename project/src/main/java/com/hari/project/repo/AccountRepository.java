package com.hari.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.project.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

}