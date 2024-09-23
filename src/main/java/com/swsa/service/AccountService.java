package com.swsa.service;
import com.swsa.model.Accountmodel;
import java.util.List;
public interface AccountService {
    Accountmodel saveAccount(Accountmodel accountmodel);
    List<Accountmodel> getAllAccounts();
    Accountmodel getAccountById(final Long accountNumber);
}
