package com.wonderlabz.victimwonderlabz.models;


import lombok.Data;

@Data
public class WithdrawRequest {

    private String accountNumber;
    private String accountType;
    private double amount;


}
