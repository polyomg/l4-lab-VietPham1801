package com.poly.lab6.lab6_jparepository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.lab6.lab6_jparepository.dao.ProductDAO;

@RestController
public class TestController {
    @Autowired
    ProductDAO productDAO;

    @GetMapping("/test")
    public Object test() {
        return productDAO.findAll();
    }
}
