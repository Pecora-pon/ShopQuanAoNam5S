package com.example.demo.controller;

import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.service.DonHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class KhachHangXemDonHang {
    @Autowired
    private DonHangChiTietService donHangChiTietService;
    @GetMapping("/dangxem")
    public String dangxem(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet, Model model, Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet> list=donHangChiTietService.findkhachHang(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/dadat";
    }
    @GetMapping("/vanchuyen")
    public String vanchuyen(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet, Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang1(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/vanchuyen";
    }
    @GetMapping("/xacnhan")
    public String xacnhan(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang2(username);
        model.addAttribute("list",list);
                return "admin/khach-hang-xem-don/xacnhan";
    }
    @GetMapping("/thanhcong")
    public String thanhcong(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang3(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/thanhcong";
    }
    @GetMapping("/dahuy")
    public String dahuy(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang4(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/dahuy";
    }
    @GetMapping("/huydx/{donHangID}")
    public String huys(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/dangxem";
    }
    @GetMapping("/huyt/{donHangID}")
    public String huyy(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/vanchuyen";
    }
    @GetMapping("/huytt/{donHangID}")
    public String huyyy(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/xacnhan";
    }
   @GetMapping("/khxacnhan/{donHangID}")
    public String xn(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensangtc(id);
        return "redirect:/xacnhan";
   }
    @GetMapping("/detail/{donHang}")
    public String detail(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/chitiet";
    }
}

