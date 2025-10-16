package com.poly.lab5.lab5springbeans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.poly.lab5.lab5springbeans.service.ShoppingCartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ShoppingCartService cartService;

    @GetMapping("/view")
    public String viewCart(Model model) {
        model.addAttribute("items", cartService.getItems());
        model.addAttribute("total", cartService.getAmount());
        model.addAttribute("count", cartService.getCount());
        return "cart/view";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cartService.add(id);
        return "redirect:/cart/view";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cartService.remove(id);
        return "redirect:/cart/view";
    }

    @GetMapping("/clear")
    public String clear() {
        cartService.clear();
        return "redirect:/cart/view";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") Integer id, @RequestParam("qty") int qty) {
        cartService.update(id, qty);
        return "redirect:/cart/view";
    }
}
