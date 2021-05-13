package com.wonderlabz.victimwonderlabz.services;

import com.wonderlabz.victimwonderlabz.models.DepositingRequest;
import com.wonderlabz.victimwonderlabz.models.DepositingResponse;

public interface DepositingService {
    DepositingResponse deposit(DepositingRequest depositingRequest);
}
