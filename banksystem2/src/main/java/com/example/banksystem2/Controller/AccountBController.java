package com.example.banksystem2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banksystem2.Entity.AccountB;
import com.example.banksystem2.Service.AccountBService;

@RestController
@RequestMapping("/accountB")
public class AccountBController {

    @Autowired
    AccountBService accountBService;

    //Create Account
    @PostMapping("/create")
    public ResponseEntity<AccountB> createAccount(@RequestBody AccountB accountB){
        AccountB createdAccount = accountBService.createAccount(accountB);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }
    
    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountB> getAccountDetail(@PathVariable Long accountNumber){
        AccountB account = accountBService.getAccountDetailByAccountNumber(accountNumber);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @GetMapping("/allAccounts")
    public ResponseEntity<List<AccountB>> getAllAccounts(){
        List<AccountB> accounts = accountBService.getAllAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public ResponseEntity<AccountB> depositMoney(@PathVariable Long accountNumber, @PathVariable Double amount){
        AccountB depositAccount = accountBService.depositMoney(accountNumber, amount);
        return ResponseEntity.status(HttpStatus.OK).body(depositAccount);
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<AccountB> withdrawMoney(@PathVariable Long accountNumber, @PathVariable Double amount){
        AccountB withdrawAccount = accountBService.withdrawMoney(accountNumber, amount);
        return ResponseEntity.status(HttpStatus.OK).body(withdrawAccount);
    }

    @DeleteMapping("/close/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        accountBService.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account number "+accountNumber+" is closed!");
    }
}
