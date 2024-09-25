package com.swsa.controller;
import com.swsa.domain.Account;
import com.swsa.model.Accountmodel;
import com.swsa.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{accountNumber}/balance")
    public Accountmodel getAccountBalance(@PathVariable Long accountNumber) {
        return accountService.getBalance(accountNumber);
    }
//
//    @PostMapping("/account")
//    public Accountmodel saveAccount(final @RequestBody Accountmodel accountmodel){
//        return accountService.saveAccount(accountmodel);
//
//    }

    @PostMapping("/account")
    public ResponseEntity<Accountmodel> saveAccount(@RequestBody Accountmodel account) {

        try {
            return ResponseEntity.ok(accountService.saveAccount(account));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Handle errors and return bad request if needed
        }
    }
    // Endpoint to deposit an amount from an account
    @PostMapping("/{id}/deposit")
    public ResponseEntity<Accountmodel> deposit(@PathVariable Long id, @RequestBody  Double amount) {
        try {
            return ResponseEntity.ok(accountService.deposit(id, amount));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint to withdraw an amount from an account
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Accountmodel> withdraw(@PathVariable Long id, @RequestParam Double amount) {
        try {
            return ResponseEntity.ok(accountService.withdraw(id, amount));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Handle errors such as insufficient funds
        }
    }



}
