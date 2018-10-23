package org.sid.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.sid.core.exception.InvalidAccountException;
import org.sid.data.AccountRepository;


@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @InjectMocks
    AccountService accountService;

    @Mock
    AccountRepository accountRepository;
    @Test(expected = InvalidAccountException.class)
    public void when_account_not_found_expect_exception() throws InvalidAccountException {

        //given
        String accountId = "myId";
        when(accountRepository.getOne(accountId)).thenReturn(null);

        //when
        accountService.getAccount(accountId);

        //then
        Assert.fail("InvalidAccountException not thrown !");
    }

}
