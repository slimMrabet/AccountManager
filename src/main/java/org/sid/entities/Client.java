package org.sid.entities;

import java.util.Collection;

public class Client {
	private Long code;
	private String name;
	private Collection<Account> accounts;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Long code, String name, Collection<Account> accounts) {
		super();
		this.code = code;
		this.name = name;
		this.accounts = accounts;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
	
}
