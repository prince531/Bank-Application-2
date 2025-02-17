package com.example.banksystem2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banksystem2.Entity.AccountB;
import com.example.banksystem2.Repository.AccountBRepository;
@Service
public class AccountBServiceImpl implements AccountBService {
    private long nextAccountNumber = 100001000;

    @Autowired
    AccountBRepository accountBRepository;

    @Override
    public AccountB createAccount(AccountB accountB) {
        accountB.setAccountNumber(generateAccountNumber());
        AccountB savedAccount = accountBRepository.save(accountB);
       return savedAccount;
    }

    private long generateAccountNumber(){
        return nextAccountNumber++;
    }
    @Override
    public AccountB getAccountDetailByAccountNumber(Long accountNumber) {
        Optional<AccountB> account = accountBRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        AccountB account_found = account.get();
        return account_found;
    }

    @Override
    public List<AccountB> getAllAccounts() {
        List<AccountB> accounts = accountBRepository.findAll();
        return accounts;
    }

    @Override
    public AccountB depositMoney(Long accountNumber, Double amount) {
        Optional<AccountB> account = accountBRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        AccountB depositAccount = account.get();
        Double totalBalance = depositAccount.getBalance()+amount;
        depositAccount.setBalance(totalBalance);
        accountBRepository.save(depositAccount);
        return depositAccount;
    }

    @Override
    public AccountB withdrawMoney(Long accountNumber, Double amount) {
        Optional<AccountB> account = accountBRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        AccountB withdrawAccount = account.get();
        Double accountBalance = withdrawAccount.getBalance()-amount;
        withdrawAccount.setBalance(accountBalance);
        accountBRepository.save(withdrawAccount);
        return withdrawAccount;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        Optional<AccountB> account = accountBRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        accountBRepository.deleteById(accountNumber);
    }
    
}
