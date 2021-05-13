package com.wonderlabz.victimwonderlabz.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonderlabz.victimwonderlabz.models.Account;
import com.wonderlabz.victimwonderlabz.models.AccountRequest;
import com.wonderlabz.victimwonderlabz.models.AccountResponse;
import com.wonderlabz.victimwonderlabz.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.wonderlabz.victimwonderlabz.data.Data.getAccountRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {AccountController.class})
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @MockBean
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("create account")
    void userRequestToRun() throws Exception {
        final String url = "/createAccount";
        final AccountResponse accountResponse =  new AccountResponse();
        accountResponse.setMessage("test run ...");
        accountResponse.setAccountNumber("222222");
        accountResponse.setStatus(true);
        given(accountService.createAccount(any(AccountRequest.class))).willReturn(accountResponse);
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(getAccountRequest())).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}