package com.wonderlabz.victimwonderlabz.models;


import com.wonderlabz.victimwonderlabz.enums.AccountType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account extends BaseEntity {

    private String firstName;
    private String lastName;
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private BigDecimal currentBalance;
    private BigDecimal deposit;


}
