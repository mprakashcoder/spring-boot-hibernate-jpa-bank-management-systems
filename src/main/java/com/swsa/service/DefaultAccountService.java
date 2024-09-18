package com.swsa.service;
import com.swsa.domain.Account;
import com.swsa.model.Accountmodel;
import com.swsa.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service("accountService")
public class DefaultAccountService implements AccountService
{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Accountmodel saveAccount(Accountmodel accountmodel) {
        Account account = populateAccountEntity(accountmodel);
        return populateAccountModel(accountRepository.save(account));
    }

    /**
     * Method to return list of all the available customers in the system.This is a simple
     * implementation but you might want to use pagination in the real world example.
     *
     * @return list of customer
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
     * Get customer by ID.The service will send the customer data else will throw the exception.
     * @param accountNumber
     * @return AccountModel
     */
    @Override
    public Accountmodel getAccountById(String accountNumber)
    {
        return populateAccountModel(accountRepository.findById(Long.valueOf(accountNumber)).orElseThrow(() -> new EntityNotFoundException("Account not found")));
    }

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param account
     * @return AccountModel
     */
    private Accountmodel populateAccountModel(final Account account){
        Accountmodel accountmodel = new Accountmodel();
        accountmodel.setId(account.getId());
        accountmodel.setAccountNumber(account.getAccountNumber());
        accountmodel.setAccountHolderName(account.getAccountHolderName());
        accountmodel.setCustomerId(account.getCustomerId());
        return  accountmodel;
    }

    /**
     * Method to map the frontend customer object to the JPA customer entity.
     * @param accountmodel
     * @return Account
     */
    private Account populateAccountEntity(Accountmodel accountmodel){
       Account account = new Account();
        accountmodel.setId(account.getId());
        accountmodel.setAccountNumber(account.getAccountNumber());
        accountmodel.setAccountHolderName(account.getAccountHolderName());
        accountmodel.setCustomerId(account.getCustomerId());
        return  account;
    }
}
