package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Trang chủ
    @GetMapping("/")
    public String index() {
        return "home/index"; // trỏ tới templates/home/index.html
    }

    // Trang giới thiệu
    @GetMapping("/about")
    public String about() {
        return "home/about"; // trỏ tới templates/home/about.html
    }

    // Trang liên hệ (nếu bạn làm thêm contact.html)
    @GetMapping("/contact")
    public String contact() {
        return "home/contact"; // trỏ tới templates/home/contact.html
    }
}
