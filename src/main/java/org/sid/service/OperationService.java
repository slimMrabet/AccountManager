package org.sid.service;

import java.util.List;

import org.sid.data.AccountRepository;
import org.sid.data.OperationRepository;
import org.sid.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	OperationRepository operationRepository;
	
	public Operation setOperation(String accountId, double amount, String operationType) {
		
	}
	
	public List<Operation> getAll(String accountId) {
		
	}

}
