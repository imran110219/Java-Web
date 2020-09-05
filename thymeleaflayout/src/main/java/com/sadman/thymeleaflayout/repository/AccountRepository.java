package com.sadman.thymeleaflayout.repository;

import com.sadman.thymeleaflayout.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findOneByEmail(String email);
}
