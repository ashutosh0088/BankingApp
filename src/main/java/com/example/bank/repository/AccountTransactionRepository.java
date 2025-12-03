package com.example.bank.repository;

import com.example.bank.domain.Account;
import com.example.bank.domain.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}
