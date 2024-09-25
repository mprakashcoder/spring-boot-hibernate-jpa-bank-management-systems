package com.swsa.repository;
import com.swsa.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
    @Repository
    public interface AccountRepository extends JpaRepository<Account,Long> {

        // Custom query to get balance by account number
        Account findBalanceByAccountNumber(Long accountNumber);
    }
