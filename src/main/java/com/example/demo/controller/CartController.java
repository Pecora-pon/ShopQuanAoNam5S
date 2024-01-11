package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.SizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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

    @PostMapping(value = "/them-gio-hang/{tenSanPham}/{hinhAnhURL}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String them(@Valid @ModelAttribute("sanpham") GioHang gioHang, @PathVariable("tenSanPham") String ten,@PathVariable("hinhAnhURL") String hinhAnhURL,@RequestParam("sizeID")int size,@RequestParam("mauSacID")int mauSac,SanPham sanPham,
                       BindingResult result,
                       Model model, Principal principal) {
        String logname = principal.getName();
        KhachHang khachHang = khachHangRepo.findByUsername(logname);
        List<GioHang> gioHangList = cartService.getAll();
        gioHang.setKhachHang(khachHang);

//        sanPhamService.size(sanPham,sanPhamID);
        cartService.insert(gioHang, ten,hinhAnhURL,size,mauSac);
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
    @GetMapping("/gio-hang/detail")
    public String detail(@RequestParam("tenSanPham")String ten,Authentication authentication,Model model){
        String logname=authentication.getName();
        List<GioHang>list=cartService.timkiem(ten,logname);
        model.addAttribute("listGioHang",list);
        return "shop/gio-hang";
    }
    @GetMapping("/gio-hang/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       Model model,
                       @Param("keyword") String keyword,Authentication authentication){
        String logname=authentication.getName();
        Page<GioHang> page1 = cartService.page(logname,page,size);
        List<GioHang> list =page1.getContent();
        List<GioHang> list1 = cartService.getAll();
        if(keyword !=null){
            list1     = this.cartService.getAllByKhachHang(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listGioHang",list);
        model.addAttribute("gh",new GioHang());
        return "shop/gio-hang";

    }
}



