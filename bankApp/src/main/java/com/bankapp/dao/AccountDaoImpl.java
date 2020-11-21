package com.bankapp.dao;

import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImpl implements AccountDao{
	
private Map<Integer,Account> accounts=new HashMap<>();
	public AccountDaoImpl() {
		accounts.put(1, new Account(1,"teju",500));
		accounts.put(2, new Account(2,"moksha",600));
		
	}
	@Override
	public List<Account> getAllAccounts() {
		
		return new ArrayList<>(accounts.values());
	}

	@Override
	public void update(Account account) {
		
		accounts.put(account.getId(), account);
		
	}

	@Override
	public Account findAccountById(int id) {
		return accounts.get(id);
	}

}
