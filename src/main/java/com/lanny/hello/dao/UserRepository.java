package com.lanny.hello.dao;

import com.lanny.hello.dao.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Integer> {

    Account findByUsername(String username);
}
