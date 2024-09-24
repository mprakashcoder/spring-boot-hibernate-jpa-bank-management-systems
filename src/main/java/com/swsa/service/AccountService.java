package com.swsa.service;
import com.swsa.domain.Account;
import com.swsa.model.Accountmodel;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface AccountService {
    Accountmodel saveAccount(Accountmodel accountmodel);

    Account deposit(Long id, Double balance) throws Exception;

    List<Accountmodel> getAllAccounts();
    Accountmodel getAccountById(final Long accountNumber);
    Account  getAccount(Long id);
}
