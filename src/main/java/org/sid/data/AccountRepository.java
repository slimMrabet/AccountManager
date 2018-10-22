package org.sid.data;

import org.sid.entities.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
	public Account getAccount(String accountId) {
		// mock the function, simulation of data layer
		return new Account();
	}
}
