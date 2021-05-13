package com.wonderlabz.victimwonderlabz.models;

import lombok.Data;

@Data
public class DepositingRequest {

    private String accountNumber;
    private String accountType;
    private double depositAmount;

}
