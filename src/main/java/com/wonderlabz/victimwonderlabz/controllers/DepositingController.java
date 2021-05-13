package com.wonderlabz.victimwonderlabz.controllers;


import com.wonderlabz.victimwonderlabz.models.DepositingRequest;
import com.wonderlabz.victimwonderlabz.models.DepositingResponse;
import com.wonderlabz.victimwonderlabz.models.WithdrawResponse;
import com.wonderlabz.victimwonderlabz.services.DepositingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositingController {

    private final DepositingService depositService;

    public DepositingController(DepositingService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/makeDeposit")
    @ApiOperation(value = "For making money deposit to Account",response = DepositingResponse.class)
    public DepositingResponse deposit(@RequestBody DepositingRequest depositingRequest){
        return depositService.deposit(depositingRequest);
    }

}
