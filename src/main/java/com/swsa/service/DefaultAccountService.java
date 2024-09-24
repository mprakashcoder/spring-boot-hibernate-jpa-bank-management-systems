package com.swsa.service;
import com.swsa.domain.Account;
import com.swsa.model.Accountmodel;
import com.swsa.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("accountService")
public class DefaultAccountService implements AccountService
{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Accountmodel saveAccount(Accountmodel account) {
        Account accountmodel = populateAccountEntity(account);
        return populateAccountModel(accountRepository.save(accountmodel));
    }

    @Transactional
    public Account deposit(Long id, Double balance) throws Exception {
        Account account = getAccount(id);
        account.setBalance(account.getBalance() + balance);
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long id) {
        return null;
    }
    /**
     * Method to return list of all the available account in the system.This is a simple
     * implementation but you might want to use pagination in the real world example.
     *
     * @return list of account
     */

    @Override
    public List<Accountmodel> getAllAccounts() {
        List<Accountmodel> accounts = new ArrayList<>();
        List<Account> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
            accounts.add(populateAccountModel(account));
        });
        return accounts;
    }


    /**
     * Get customer by ID.The service will send the account data else will throw the exception.
     * @param accountNumber
     * @return AccountModel
     */
    @Override
    public Accountmodel getAccountById(Long accountNumber)
    {
        return populateAccountModel(accountRepository.findById(accountNumber).orElseThrow(() -> new EntityNotFoundException("Account not found")));
    }



    /**
     * Internal method to convert Account JPA entity to the DTO object
     * for frontend data
     * @param account
     * @return AccountModel
     */


    private Accountmodel populateAccountModel(final Account account){
        Accountmodel accountmodel = new Accountmodel();
        accountmodel.setId(account.getId());
        accountmodel.setAccountNumber(account.getAccountNumber());
        accountmodel.setAccountHolderName(account.getAccountHolderName());
        accountmodel.setBalance(account.getBalance());
        accountmodel.setCustomerId(account.getCustomerId());
        return  accountmodel;
    }

    /**
     * Method to map the frontend account object to the JPA account entity.
     * @param accountmodel
     * @return Account
     */

    private Account populateAccountEntity(Accountmodel accountmodel){
       Account account = new Account();
        account.setAccountNumber(accountmodel.getAccountNumber());
        account.setAccountHolderName(accountmodel.getAccountHolderName());
        account.setBalance(accountmodel.getBalance());
        account.setCustomerId(accountmodel.getCustomerId());
        return  account;
    }
}
