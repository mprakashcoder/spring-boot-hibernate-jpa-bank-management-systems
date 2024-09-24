package com.swsa.controller;
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

    @PutMapping("/deposit/{id}")
    public ResponseEntity<Accountmodel> deposit(@PathVariable Long id, @RequestBody  Double balance) {
        try {
            return ResponseEntity.ok(accountService.deposit(id, balance));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
