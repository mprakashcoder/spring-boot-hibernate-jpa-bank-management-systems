package com.swsa.controller;
import com.swsa.model.Accountmodel;
import com.swsa.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value ="/accountManagement")
public class AccountController {

    @Resource(name = "accountService")
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Accountmodel> geAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public Accountmodel getAccount(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping("/account")
    public Accountmodel saveAccount(final @RequestBody Accountmodel accountmodel){
        return accountService.saveAccount(accountmodel);
    }

}
