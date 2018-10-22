package org.sid.service;

import org.sid.core.exception.InvalidAccountException;
import org.sid.data.AccountRepository;
import org.sid.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

	public Account getAccount(String accountId) throws InvalidAccountException {
		Account account =  accountRepository.getAccount(accountId);
		if (account == null) {
			  throw new InvalidAccountException();
		}
		return account;
	}

}
