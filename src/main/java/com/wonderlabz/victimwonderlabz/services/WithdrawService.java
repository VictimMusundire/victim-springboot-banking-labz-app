package com.wonderlabz.victimwonderlabz.services;

import com.wonderlabz.victimwonderlabz.models.WithdrawRequest;
import com.wonderlabz.victimwonderlabz.models.WithdrawResponse;

public interface WithdrawService {
    WithdrawResponse money(WithdrawRequest withdrawRequest);
}
