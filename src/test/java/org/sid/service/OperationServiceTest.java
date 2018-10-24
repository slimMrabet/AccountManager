package org.sid.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.sid.core.exception.InvalidParamsException;
import org.sid.core.exception.UnauthorizedOperationException;
import org.sid.data.AccountRepository;
import org.sid.data.OperationRepository;
import org.sid.entities.Account;
import org.sid.entities.Operation;
import org.sid.core.resources.*;
@RunWith(MockitoJUnitRunner.class)

public class OperationServiceTest {
	@InjectMocks
	OperationService operationService;

	@Mock
	AccountRepository accountRepository;

	@Mock
	OperationRepository operationRepository;
	
	@Test(expected = InvalidParamsException.class)
	public void when_setOperation_invalid_amount_expect_exception_depositCase() throws InvalidParamsException, UnauthorizedOperationException {
		//given
		String accountId = "myId";
		int amount = -100;
		Operation operation = new Operation();
		operation.setType(Resources.Deposit);
		Account account = new Account();
		//when
		operationService.setOperation(accountId, amount, operation.getType());
	
		//then
        Assert.fail("InvalidParamsException not thrown !");
	}
	
	@Test(expected = InvalidParamsException.class)
	public void when_setOperation_invalid_amount_expect_exception_withdrawalCase() throws InvalidParamsException, UnauthorizedOperationException {
		//given
		String accountId = "myId";
		int amount = -100;
		Operation operation = new Operation();
		operation.setType(Resources.Withdrawal);
		//when
		operationService.setOperation(accountId, amount, operation.getType());
	
		//then
        Assert.fail("InvalidParamsException not thrown !");
	}
	
	@Test
	public void when_setOperation_valid_depositCase() throws InvalidParamsException, UnauthorizedOperationException {
		//given
	    String accountId = "myId";
	    int amount = 100;
		Operation operation = new Operation();
		operation.setType(Resources.Deposit);
		Account account = new Account();
		when(accountRepository.getOne(accountId)).thenReturn(account);
	    Operation operationToSave = operation;
        //when
	    Operation result = operationService.setOperation(accountId, amount, operationToSave.getType());
	    //then
	    assertThat(result).isNotNull();
	}
	
	@Test
	public void when_setOperation_valid_withdrawalCase() throws InvalidParamsException, UnauthorizedOperationException {
		//given
	    String accountId = "myId";
	    int amount = 100;
		Operation operation = new Operation();
		operation.setType(Resources.Withdrawal);
		Account account = new Account();
		when(accountRepository.getOne(accountId)).thenReturn(account);
	    Operation operationToSave = operation;
        //when
	    Operation result = operationService.setOperation(accountId, amount, operationToSave.getType());
	    //then
	    assertThat(result).isNotNull();
	}
	
	@Test(expected = UnauthorizedOperationException.class)
	public void when_setOperation_invalid_balance_expect_UnauthorizedOperationException_withdrawalCase() throws InvalidParamsException, UnauthorizedOperationException {
		//given
		String accountId = "myId";
		int amount = 100;
		Operation operation = new Operation();
		operation.setType(Resources.Withdrawal);
		Account account = new Account();
		account.setBalance(Resources.minBalance);
		when(accountRepository.getOne(accountId)).thenReturn(account);
		//when
		operationService.setOperation(accountId, amount, operation.getType());
	
		//then
        Assert.fail("UnauthorizedOperationException not thrown !");
	}
}
