package com.wonderlabz.victimwonderlabz.models;

import lombok.Data;

@Data
public class DepositingResponse {
    private String message;
    private boolean status;
    private String accountNumber;
}
