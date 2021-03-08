package com.bankapp.web.formbeans;

import org.hibernate.validator.constraints.NotEmpty;

public class Transferbean {
	
	private Integer fromAccountId;
	
	private Integer toAccountId;
	
	//@NotEmpty(message = "amount can not be left blank")
	private Double amount;
	public Integer getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Integer getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Transferbean() {
		
	}
	
	
}
