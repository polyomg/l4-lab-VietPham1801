package com.poly.lab5.lab5springbeans.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.lab5.lab5springbeans.service.ParamService;

@Controller
public class RegisterController {

    @Autowired
    ParamService paramService;

    @GetMapping("/register")
    public String showForm() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("photo") MultipartFile photo,
            Model model) {

        try {
            // Lưu hình ảnh upload vào thư mục /uploads
            File savedFileName = paramService.save(photo, "/uploads/");

            // Hiển thị thông tin đã nhập
            model.addAttribute("message", "Đăng ký thành công!");
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            model.addAttribute("photo", savedFileName);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Đăng ký thất bại: " + e.getMessage());
        }

        return "register";
    }
}
