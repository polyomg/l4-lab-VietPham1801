package com.poly.controller;

import com.poly.lab4.model.Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    // Hiển thị form tạo nhân viên
    @GetMapping("/create/form")
    public String createForm(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "home/staff-create"; // trỏ tới templates/home/staff-create.html
    }

    // Xử lý khi nhấn nút Create
    @PostMapping("/save")
    public String createSave(Model model,
                             @RequestParam("photo") MultipartFile photoFile, // phải trùng với name="photo" trong form
                             @Valid @ModelAttribute("staff") Staff staff,
                             Errors errors) {

        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Nhân viên " + staff.getFullname() + " đã được thêm thành công!");
        }

        return "home/staff-create";
    }

    // ✅ Hiển thị danh sách nhân viên
    @GetMapping("/list")
    public String list(Model model) {
        List<Staff> staffs = new ArrayList<>();
        // Test dữ liệu tạm
        staffs.add(Staff.builder()
                .id("E01")
                .fullname("Nguyễn Văn A")
                .email("a@gmail.com")
                .photo("a.jpg")
                .gender(true)
                .salary(5000.0)
                .level(0)
                .build());
        staffs.add(Staff.builder()
                .id("E02")
                .fullname("Trần Thị B")
                .email("b@gmail.com")
                .photo("b.jpg")
                .gender(false)
                .salary(7000.0)
                .level(1)
                .build());

        model.addAttribute("list", staffs);
        return "home/staff-list"; // => templates/home/staff-list.html
    }
}
