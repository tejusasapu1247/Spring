package com.bankapp.web.formbeans;

import org.hibernate.validator.constraints.NotEmpty;

public class Depositbean {
	
	private Integer accountId;
	
	//@NotEmpty(message = "amount can not be left blank")
	private Double amount;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Depositbean() {
	}
	
	
	
}
