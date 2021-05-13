package com.wonderlabz.victimwonderlabz.models;


import lombok.Data;

@Data
public class AccountResponse {

    private String message;
    private boolean status;
    private String accountNumber;

}
