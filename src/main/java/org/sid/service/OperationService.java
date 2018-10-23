package org.sid.service;

import java.util.Date;
import java.util.List;

import org.sid.core.exception.InvalidParamsException;
import org.sid.data.AccountRepository;
import org.sid.data.OperationRepository;
import org.sid.entities.Account;
import org.sid.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	OperationRepository operationRepository;
	
	public Operation setOperation(String accountId, double amount, String operationType) throws InvalidParamsException {
		if (amount < 0) {
			throw new InvalidParamsException();
		}
		Operation operation = new Operation();
		Account account = accountRepository.getOne(accountId);
		operation.setAmount(amount);
		operation.setDateOperation(new Date());
		operation.setType(operationType);
		operation.setAccount(account);
		operationRepository.save(operation);
		return operation;
	}
	
	public List<Operation> getAll(String accountId) {
		return operationRepository.getByAccount(accountId);
	}

}
