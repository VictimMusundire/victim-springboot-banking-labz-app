package com.wonderlabz.victimwonderlabz.services;


import com.wonderlabz.victimwonderlabz.models.AccountRequest;
import com.wonderlabz.victimwonderlabz.models.AccountResponse;

public interface AccountService {

    AccountResponse createAccount(AccountRequest accountRequest);
}
