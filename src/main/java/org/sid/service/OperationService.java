package org.sid.service;

import java.util.Date;
import java.util.List;

import org.sid.core.exception.InvalidParamsException;
import org.sid.core.exception.UnauthorizedOperationException;
import org.sid.core.resources.Resources;
import org.sid.data.AccountRepository;
import org.sid.data.OperationRepository;
import org.sid.entities.Account;
import org.sid.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService implements OperationServiceInterface {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	OperationRepository operationRepository;
	
	@Override
	public Operation setOperation(String accountId, int amount, String operationType) throws InvalidParamsException, UnauthorizedOperationException {
		if (amount < 0) {
			throw new InvalidParamsException();
		}
		Operation operation = new Operation();
		Account account = accountRepository.getOne(accountId);
		int currentBalance = account.getBalance();
		int newBalance;
		operation.setAmount(amount);
		operation.setDateOperation(new Date());
		operation.setType(operationType);
		operation.setAccount(account);
		switch (operationType) {
			case Resources.Withdrawal:
				newBalance = currentBalance - amount;
				if (newBalance < Resources.minBalance)
					throw new UnauthorizedOperationException();
				break;
			case Resources.Deposit:
				newBalance = currentBalance + amount;
				break;
			default:
				throw new InvalidParamsException();
		}
		account.setBalance(newBalance);
		operationRepository.save(operation);
		return operation;
	}
	
	@Override
	public List<Operation> getAll(String accountId) {
		return operationRepository.getByAccount(accountId);
	}

}
