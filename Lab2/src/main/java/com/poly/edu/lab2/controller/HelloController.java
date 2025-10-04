package com.poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/poly/hello")
    public String hello() {
        return "hello"; // sẽ tìm file hello.html trong src/main/resources/templates
    }
}
