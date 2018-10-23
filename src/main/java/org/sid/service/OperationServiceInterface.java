package org.sid.service;

import java.util.List;

import org.sid.core.exception.InvalidParamsException;
import org.sid.entities.Operation;

public interface OperationServiceInterface {
	public Operation setOperation(String accountId, double amount, String operationType) throws InvalidParamsException;
	public List<Operation> getAll(String accountId);
}
