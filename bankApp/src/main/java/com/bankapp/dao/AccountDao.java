package com.bankapp.dao;
import java.util.*;
public interface AccountDao {
	public List<Account> getAllAccounts();
public void update(Account account);
public Account findAccountById(int id);
}
