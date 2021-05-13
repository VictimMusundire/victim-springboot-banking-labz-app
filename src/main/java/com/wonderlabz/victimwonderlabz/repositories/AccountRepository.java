package com.wonderlabz.victimwonderlabz.repositories;

import com.wonderlabz.victimwonderlabz.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findAccountByAccountNumber(String accountNumber);
}
