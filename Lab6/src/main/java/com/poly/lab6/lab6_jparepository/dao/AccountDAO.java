package com.poly.lab6.lab6_jparepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab6.lab6_jparepository.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
}
