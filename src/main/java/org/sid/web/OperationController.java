package org.sid.web;

import java.util.List;

import org.sid.core.exception.InvalidParamsException;
import org.sid.entities.Operation;
import org.sid.service.OperationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
	@Autowired 
	OperationServiceInterface operationService;
	
	@RequestMapping(value="/operations/{accountId}", method=RequestMethod.GET)
	public List<Operation> getAll(@PathVariable(name="accountId") String accountId) {
		return operationService.getAll(accountId);
		
	}
	
	@RequestMapping(value="/setOperation/{accountId}/{amount}/{type}", method=RequestMethod.POST)
	public Operation setOperation( @PathVariable(name="accountId") String accountId, @PathVariable(name="amount") Double amount, @PathVariable(name="type") String type ) throws InvalidParamsException {
		return operationService.setOperation(accountId, amount, type);
		
	}
	
}
