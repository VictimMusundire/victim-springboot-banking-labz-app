package com.wonderlabz.victimwonderlabz.controllers;


import com.wonderlabz.victimwonderlabz.models.AccountRequest;
import com.wonderlabz.victimwonderlabz.models.AccountResponse;
import com.wonderlabz.victimwonderlabz.services.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createAccount")
    @ApiOperation(value = "For Opening an Account",response = AccountResponse.class)
    public AccountResponse createAccount(@RequestBody AccountRequest accountRequest){
        return accountService.createAccount(accountRequest);
    }

}
