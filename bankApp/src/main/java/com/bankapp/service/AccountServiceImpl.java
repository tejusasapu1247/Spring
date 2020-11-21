package com.bankapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.*;
@Service(value="accountService")
public class AccountServiceImpl implements AccountService{
	private AccountDao dao;
	
	public void setDao(AccountDao dao) {
		this.dao = dao;
	}
	
public AccountServiceImpl() {}
@Autowired()
	public AccountServiceImpl(AccountDao dao) {
		this.dao = dao;
	}


	@Override
	public List<Account> getAllAccounts() {
	
		return dao.getAllAccounts();
	}

	@Override
	public void update(Account account) {
		dao.update(account);
		
	}

	@Override
	public Account findAccountById(int id) {
		
		return dao.findAccountById(id);
	}

	@Override
	public void transfer(int fromId, int toId, int amount) {
		//first load the first account then get the second account
		//deduce the amount fromAc,deposit toAcc
		//update the account
		Account fromAc=dao.findAccountById(fromId);
		Account toAccount=dao.findAccountById(toId);
		fromAc.setBalance(fromAc.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		dao.update(fromAc);
		dao.update(toAccount);
		
		
	}

}
