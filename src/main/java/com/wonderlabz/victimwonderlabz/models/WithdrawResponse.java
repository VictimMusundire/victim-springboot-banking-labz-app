package com.wonderlabz.victimwonderlabz.models;


import lombok.Data;

@Data
public class WithdrawResponse {

    private String message;
    private boolean status;
    private String accountNumber;

}
