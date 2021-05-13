package com.wonderlabz.victimwonderlabz.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountRequest {

    private String firstName;
    private String lastName;
    private String accountType;
    private double deposit;
    private String accountNumber;
}
