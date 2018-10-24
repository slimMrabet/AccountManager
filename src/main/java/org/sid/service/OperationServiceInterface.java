package org.sid.service;

import java.util.List;

import org.sid.core.exception.InvalidParamsException;
import org.sid.core.exception.UnauthorizedOperationException;
import org.sid.entities.Operation;

public interface OperationServiceInterface {
	public Operation setOperation(String accountId, int amount, String operationType) throws InvalidParamsException, UnauthorizedOperationException;
	public List<Operation> getAll(String accountId);
}
