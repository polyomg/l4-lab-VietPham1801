package com.poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumController {

    @GetMapping("/sum/form")
    public String showForm() {
        return "sum"; // hiển thị sum.html
    }

    @PostMapping("/sum/calc")
    public String calculate(
            @RequestParam("a") double a,
            @RequestParam("b") double b,
            Model model) {

        double result = a + b;
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", result);

        return "sum";
    }
}
