package com.wonderlabz.victimwonderlabz.services;

import com.wonderlabz.victimwonderlabz.models.Account;
import com.wonderlabz.victimwonderlabz.models.DepositingRequest;
import com.wonderlabz.victimwonderlabz.models.DepositingResponse;
import com.wonderlabz.victimwonderlabz.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
public class DepositingServiceImpl implements DepositingService {

    private final AccountRepository accountRepository;

    public DepositingServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public DepositingResponse deposit(DepositingRequest depositingRequest) {

        log.info("deposit transaction initiated with details: " + depositingRequest);

        DepositingResponse depositingResponse = new DepositingResponse();
        Optional<Account> account = accountRepository
                .findAccountByAccountNumber(depositingRequest.getAccountNumber());
        if(!account.isPresent()){
            depositingResponse.setMessage("Not Found");
            depositingResponse.setStatus(false);
            return depositingResponse;
        }

        account.get().setCurrentBalance(account.get().getCurrentBalance()
                .add(BigDecimal.valueOf(depositingRequest.getDepositAmount())));

        Account save = accountRepository.save(account.get());
        depositingResponse.setMessage("Successfully Deposited");
        depositingResponse.setStatus(true);
        depositingResponse.setAccountNumber(save.getAccountNumber());

        log.info("deposit transaction made: " + account);
        return depositingResponse;
    }
}
