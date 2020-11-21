package com.bankapp.service;

import java.util.List;

import com.bankapp.dao.Account;

public interface AccountService {
public List<Account> getAllAccounts();
public void update(Account account);
public Account findAccountById(int id);
public void transfer(int fromId,int toId,int amount);
}
