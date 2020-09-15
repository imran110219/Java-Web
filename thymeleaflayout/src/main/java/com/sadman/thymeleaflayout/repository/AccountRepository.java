package com.sadman.thymeleaflayout.repository;

import com.sadman.thymeleaflayout.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findOneByEmail(String email);
    Account findOne(Long id);
}
