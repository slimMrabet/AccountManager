package org.sid.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client {
	@Id @GeneratedValue
	private Long code;
	private String name;
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Account> accounts;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client( String name) {
		super();
		this.name = name;
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
