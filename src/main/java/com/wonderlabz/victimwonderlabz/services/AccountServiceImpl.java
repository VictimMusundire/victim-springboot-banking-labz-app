package com.wonderlabz.victimwonderlabz.services;


import com.wonderlabz.victimwonderlabz.enums.AccountType;
import com.wonderlabz.victimwonderlabz.models.Account;
import com.wonderlabz.victimwonderlabz.models.AccountRequest;
import com.wonderlabz.victimwonderlabz.models.AccountResponse;
import com.wonderlabz.victimwonderlabz.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {

        AccountResponse accountResponse = new AccountResponse();

        log.info("account opening request" + accountRequest);

        Optional<Account> account1 = accountRepository.findAccountByAccountNumber(accountRequest.getAccountNumber());

        if(account1.isPresent()){
            accountResponse.setMessage("Account Exists");
            accountResponse.setStatus(false);
            accountResponse.setAccountNumber(accountRequest.getAccountNumber());
            return accountResponse;
        }

        if(accountRequest.getFirstName() == null){
            accountResponse.setMessage("First Name is required");
            accountResponse.setStatus(false);
            return accountResponse;
        }
        if(accountRequest.getLastName() == null){
            accountResponse.setMessage("Last Name is required");
            accountResponse.setStatus(false);
            return accountResponse;
        }
        if(accountRequest.getAccountType() == null){
            accountResponse.setMessage("Account Type is required");
            accountResponse.setStatus(false);
            return accountResponse;
        }
        if(accountRequest.getAccountNumber() == null){
            accountResponse.setMessage("Account Number is required");
            accountResponse.setStatus(false);
            return accountResponse;
        }
        if(accountRequest.getDeposit() < 1000.00){
            accountResponse.setMessage("Deposit must be a minimum of R1000.00");
            accountResponse.setStatus(false);
            return accountResponse;
        }

        final Account createAccount = accountRepository.save(saveAccount(accountRequest));
        accountResponse.setMessage("Account Created Successfully");
        accountResponse.setStatus(true);
        accountResponse.setAccountNumber(createAccount.getAccountNumber());
        return accountResponse;
    }

    private Account saveAccount(AccountRequest accountRequest) {
        final Account account =  new Account();
        account.setAccountType(AccountType.valueOf(accountRequest.getAccountType().toUpperCase()));
        account.setDeposit(BigDecimal.valueOf(accountRequest.getDeposit()));
        account.setFirstName(accountRequest.getFirstName());
        account.setLastName(accountRequest.getLastName());

        log.info("created account details " + account);
        return account;
    }

}
