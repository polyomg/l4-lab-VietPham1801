package com.poly.edu.lab2.controller;

import com.poly.edu.lab2.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String productList(Model model) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("IPhone 15", 2500));
        products.add(new Product("Samsung S24", 2000));
        products.add(new Product("Oppo Find X7", 1500));

        model.addAttribute("products", products);
        return "product"; // => Trỏ đến file product.html
    }
}
