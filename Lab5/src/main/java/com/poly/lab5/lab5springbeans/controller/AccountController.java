package com.poly.lab5.lab5springbeans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.poly.lab5.lab5springbeans.service.CookieService;
import com.poly.lab5.lab5springbeans.service.ParamService;
import com.poly.lab5.lab5springbeans.service.SessionService;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public String loginForm() {
        return "account/login";
    }

    @PostMapping("/login")
    public String loginSubmit() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if (username.equals("poly") && password.equals("123")) {
            sessionService.set("username", username);

            if (remember) {
                cookieService.add("user", username, 24 * 10); // 10 ngày
            } else {
                cookieService.remove("user");
            }
            return "redirect:/account/success";
        }
        return "account/login";
    }

    @GetMapping("/success")
    public String success() {
        return "account/success";
    }
}
