package com.poly.lab6.lab6_jparepository.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.lab6.lab6_jparepository.dao.ProductDAO;
import com.poly.lab6.lab6_jparepository.entity.Product;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    // -----------------------------
    // BÀI 3: SẮP XẾP THEO CỘT
    // -----------------------------
    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {

        // Nếu chưa chọn cột thì mặc định sắp theo "price" giảm dần
        Sort sort = Sort.by(Direction.DESC, field.orElse("price"));

        // Lưu tên cột để hiển thị tiêu đề
        model.addAttribute("field", field.orElse("price").toUpperCase());

        // Lấy danh sách sản phẩm đã sắp xếp
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);

        return "product/sort";
    }

    // -----------------------------
    // BÀI 4: PHÂN TRANG (MỖI TRANG 5 SẢN PHẨM)
    // -----------------------------
    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5); // Trang hiện tại, mỗi trang 5 sản phẩm
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }
}
