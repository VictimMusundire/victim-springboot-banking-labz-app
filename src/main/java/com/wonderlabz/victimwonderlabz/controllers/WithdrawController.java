package com.wonderlabz.victimwonderlabz.controllers;


import com.wonderlabz.victimwonderlabz.models.WithdrawRequest;
import com.wonderlabz.victimwonderlabz.models.WithdrawResponse;
import com.wonderlabz.victimwonderlabz.services.WithdrawService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WithdrawController {

    private final WithdrawService withdrawalService;

    public WithdrawController(WithdrawService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }
    @PostMapping("/makeWithdrawal")
    @ApiOperation(value = "For withdrawing money from Account",response = WithdrawResponse.class)
    public WithdrawResponse withdrawMoney(@RequestBody WithdrawRequest withdrawRequest){
        return withdrawalService.money(withdrawRequest);
    }

}
