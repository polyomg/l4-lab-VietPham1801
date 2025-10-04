package com.poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParamController {

    // @RequestParam demo
    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name,
                       @RequestParam("age") int age,
                       Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "form";
    }

    // @PathVariable demo
    @GetMapping("/param/{name}/{age}")
    public String param(@PathVariable("name") String name,
                        @PathVariable("age") int age,
                        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "form";
    }
}
