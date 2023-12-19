package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.SizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller

public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhachHangRepo khachHangRepo;
    @Autowired
    private SizeService sizeService;

    @GetMapping("/gio-hang")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getAll(Model model, Authentication authentication) {
        String username=authentication.getName();
        List<GioHang> gioHangList = cartService.getAllByKhachHang(username);
        model.addAttribute("listGioHang", gioHangList);
        model.addAttribute("gh", new GioHang());
        return "shop/gio-hang";
    }

    @PostMapping(value = "/them-gio-hang/{sanPhamID}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String them(@Valid @ModelAttribute("sanpham") GioHang gioHang, @PathVariable("sanPhamID") UUID sanPhamID,SanPham sanPham,
                       BindingResult result,
                       Model model, Principal principal) {
        String logname = principal.getName();
        KhachHang khachHang = khachHangRepo.findByUsername(logname);
        List<GioHang> gioHangList = cartService.getAll();
        gioHang.setKhachHang(khachHang);

//        sanPhamService.size(sanPham,sanPhamID);
        cartService.insert(gioHang, sanPhamID);
        List<Size>sizeList=sizeService.getAll();
        model.addAttribute("listSize",sizeList);
        model.addAttribute("listGioHang", gioHangList);
        model.addAttribute("sp",new GioHang());
        return "redirect:/gio-hang";
    }

    @RequestMapping("/gio-hang-update/{gioHangID}")
    public String viewupdate(@PathVariable("gioHangID") int gioHangID, Model model) {
        GioHang gioHang = cartService.detail(gioHangID);
        model.addAttribute("gh", gioHang);
        return "shop/gio-hangdemo";
    }

    @RequestMapping(value = "/update/{gioHangID}",method = RequestMethod.POST)
    public String update(@PathVariable("gioHangID") int id, GioHang gioHang, Model model) {
        List<GioHang> gioHangList = cartService.getAll();
        model.addAttribute("listGioHang", gioHangList);
        cartService.update(id, gioHang);
        return "redirect:/gio-hang";
    }
    @RequestMapping("/deletedh/{gioHangID}")
    public String delete(@PathVariable("gioHangID")int gioHangID){
        cartService.delete(gioHangID);
        return "redirect:/gio-hang";
    }
}



