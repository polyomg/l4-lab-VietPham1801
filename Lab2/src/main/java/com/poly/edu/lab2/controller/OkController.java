package com.poly.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ctrl")
public class OkController {

    // trang ok mặc định
    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }

    // OK 1 → POST`
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("method", "m1()");
        return "ok";
    }

    // OK 2 → GET
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("method", "m2()");
        return "ok";
    }

    // OK 3 → param ?x
    @RequestMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("method", "m3()");
        return "ok";
    }
}
