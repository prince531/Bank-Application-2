package com.example.banksystem2.Service;

import java.util.List;

import com.example.banksystem2.Entity.AccountB;

public interface AccountBService {
    public AccountB createAccount(AccountB accountB);
    public AccountB getAccountDetailByAccountNumber(Long accountNumber);
    public List<AccountB> getAllAccounts();
    public AccountB depositMoney(Long accountNumber, Double amount);
    public AccountB withdrawMoney(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
}
