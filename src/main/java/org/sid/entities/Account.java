package org.sid.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Account {
	@Id @GeneratedValue
	private String id;
	private double balance;
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	private Client client;
	@OneToMany(mappedBy="account")
	private Collection<Operation> operations;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(double balance, Client client) {
		super();
		this.balance = balance;
		this.client = client;
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
