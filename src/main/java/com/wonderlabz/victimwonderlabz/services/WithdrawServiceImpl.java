package com.wonderlabz.victimwonderlabz.services;

import com.wonderlabz.victimwonderlabz.enums.AccountType;
import com.wonderlabz.victimwonderlabz.models.Account;
import com.wonderlabz.victimwonderlabz.models.WithdrawRequest;
import com.wonderlabz.victimwonderlabz.models.WithdrawResponse;
import com.wonderlabz.victimwonderlabz.repositories.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
public class WithdrawServiceImpl implements WithdrawService {


    private final AccountRepository accountRepository;

    public WithdrawServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public WithdrawResponse money(WithdrawRequest withdrawRequest) {

        log.info("withdrawal transaction initiated " + withdrawRequest);
        WithdrawResponse withdrawResponse = new WithdrawResponse();

        Optional<Account> account = accountRepository
                .findAccountByAccountNumber(withdrawRequest.getAccountNumber());

        if (!account.isPresent()) {
            withdrawResponse.setMessage("Account not found");
            withdrawResponse.setStatus(false);
            return withdrawResponse;
        }

        if (account.get().getAccountType().getDescription().equalsIgnoreCase("SAVINGS")) {

            double currentBalance = getBalance(withdrawRequest, account);
            double overdraft = overdraft(account);

            if (currentBalance <= 1000.00) {
                withdrawResponse.setMessage("You are not allowed to go below minimum balance");
                withdrawResponse.setStatus(false);
                return withdrawResponse;
            }


            if (currentBalance < -100_000.00) {
                withdrawResponse.setMessage("Not allowed above overdraft limit");
                withdrawResponse.setStatus(false);
                return withdrawResponse;
            }

            if (withdrawRequest.getAmount() > (overdraft + account.get().getCurrentBalance().doubleValue())) {
                withdrawResponse.setMessage("Amount provided not allowed");
                withdrawResponse.setStatus(false);
                return withdrawResponse;
            }
        }
        log.info("details: " + account);
        return withdraw(withdrawResponse,account);
    }





    private WithdrawResponse withdraw(WithdrawResponse withdrawResponse, Optional<Account> account) {

        Account save = accountRepository.save(account.get());
        withdrawResponse.setMessage("Successfully withdrawn");
        withdrawResponse.setStatus(false);
        withdrawResponse.setAccountNumber(save.getAccountNumber());
        return withdrawResponse;
    }

    private double overdraft(Optional<Account> account) {
        return account.get().getCurrentBalance().doubleValue() * 3;
    }

    private double getBalance(WithdrawRequest withdrawRequest, Optional<Account> account) {
        return account.get().getCurrentBalance().doubleValue() -
                withdrawRequest.getAmount();
    }
}
