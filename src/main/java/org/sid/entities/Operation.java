package org.sid.entities;

import java.util.Date;

public class Operation {
	private Long num;
	private Date dateOperation;
	private double amount;
	private Account account;
	private String type;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Long num, Date dateOperation, double amount, Account account, String type) {
		super();
		this.num = num;
		this.dateOperation = dateOperation;
		this.amount = amount;
		this.account = account;
		this.type = type;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
