package com.swsa.service;
import com.swsa.domain.Account;
import com.swsa.model.Accountmodel;

import java.util.List;
public interface AccountService {
    Accountmodel saveAccount(Accountmodel accountmodel);

    Accountmodel deposit(Long id, Double amount) throws Exception;
    Accountmodel withdraw(Long id, Double amount) throws Exception;

    Account getBalance(Long  accountNumber);
    List<Accountmodel> getAllAccounts();
    Accountmodel getAccountById(final Long accountNumber);
    Account  getAccount(Long id);
}
