package com.poly.lab6.lab6_jparepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.lab6.lab6_jparepository.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {
}
