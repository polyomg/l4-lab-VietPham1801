package com.poly.lab6.lab6_jparepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab6.lab6_jparepository.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {
}
