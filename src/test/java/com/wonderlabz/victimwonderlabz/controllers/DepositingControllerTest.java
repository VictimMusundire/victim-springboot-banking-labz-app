package com.wonderlabz.victimwonderlabz.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonderlabz.victimwonderlabz.models.DepositingRequest;
import com.wonderlabz.victimwonderlabz.models.DepositingResponse;
import com.wonderlabz.victimwonderlabz.services.DepositingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.wonderlabz.victimwonderlabz.data.Data.depositing;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {DepositingController.class})
class DepositingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @MockBean
    private DepositingService depositService;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("depositing money")
    void depositToRun() throws Exception {
        final String url = "/makeDeposit";
        final DepositingResponse depositingResponse =  new DepositingResponse();
        depositingResponse.setMessage("successful deposit");
        depositingResponse.setStatus(true);
        depositingResponse.setAccountNumber(depositingResponse.getAccountNumber());
        given(depositService.deposit(any(DepositingRequest.class))).willReturn(depositingResponse);
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(depositing())).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}