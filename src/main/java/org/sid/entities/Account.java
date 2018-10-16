package org.sid.entities;

import java.util.Collection;

public class Account {
	private String id;
	private double balance;
	private Client client;
	private Collection<Operation> operations;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String id, double balance, Client client, Collection<Operation> operations) {
		super();
		this.id = id;
		this.balance = balance;
		this.client = client;
		this.operations = operations;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	

}
