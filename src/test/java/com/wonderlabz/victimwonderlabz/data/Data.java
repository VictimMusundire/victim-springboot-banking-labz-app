package com.wonderlabz.victimwonderlabz.data;

import com.wonderlabz.victimwonderlabz.enums.AccountType;
import com.wonderlabz.victimwonderlabz.models.AccountRequest;
import com.wonderlabz.victimwonderlabz.models.DepositingRequest;

public class Data {


    public static DepositingRequest depositing(){
        final DepositingRequest depositRequest = new DepositingRequest();
        depositRequest.setDepositAmount(5000.00);
        depositRequest.setAccountNumber("123456789");
        return depositRequest;
    }

    public static AccountRequest getAccountRequest() {
        final AccountRequest accountRequest = new AccountRequest();
        accountRequest.setAccountType(AccountType.SAVINGS.getDescription());
        accountRequest.setFirstName("Victim");
        accountRequest.setLastName("Musundire");
        accountRequest.setDeposit(100000.00);
        accountRequest.setAccountNumber("12345678");
        return accountRequest;
    }
}
