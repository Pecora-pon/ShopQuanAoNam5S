package com.example.demo.controller;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.SanPham;
import com.example.demo.service.CartService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private SanPhamService sanPhamService;
    @RequestMapping("/gio-hang")
    public String getAll(Model model){
        List<GioHang> gioHangList = cartService.getAll();
        model.addAttribute("listCart",gioHangList);
        model.addAttribute("gh",new GioHang());
        return "shop/gio-hang";
    }
//    @GetMapping("/gio-hang/them-gio-hang/{sanPhamID}")
//    public String addCart(@PathVariable("sanPhamID")UUID sanPhamID){
//        sanPhamService.findByID(sanPhamID).ifPresent(cartService::add);
//        return addCart();
//    }
}



