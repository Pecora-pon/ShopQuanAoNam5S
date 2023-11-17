package com.example.demo.controller;


import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import com.example.demo.servicesecuritykh.KhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhService khService;
    @Autowired
    private JavaMailSender mailSender;
    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }



    @RequestMapping("/trang-chu/sign-up")
    public String sigunup(@ModelAttribute("kh")KhachHang khachHang) {
        return "admin/dangky";
    }

    @RequestMapping("/trang-chu/sign-up-add")
    public String sigunupadd(@ModelAttribute("kh")KhachHang khachHang,
                          @RequestParam("email") String to,
                          @RequestParam("username")String username,
                          @RequestParam("password") String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("THÔNG TIN TÀI KHOẢN KHÁCH HÀNG MỚI");
        message.setText("Xin chào,"+"đây là tài khoản và mật khẩu của bạn."+"\n Tài khoản: "+username+"\n Mật khẩu: "+password);
        mailSender.send(message);
        khService.addKH(khachHang);
        return "admin/login";
    }

    @RequestMapping("/shop/main-shop")
    public String mainshop() {
        return "shop/index";
    }

    @RequestMapping("/trang-chu")
    public String res() {
        return "admin/index";
    }

    @RequestMapping("/responsive/thong-tin-tai-khoan")
    public String data() {
        return "admin/thongtintaikhoan";
    }

    @RequestMapping("/doimatkhau")
    public String pass() {
        return "admin/doimatkhau";
    }

//    @RequestMapping("/gio-hang")
//    public String giohang() {
//        return "shop/gio-hang";
//    }
//
//    @RequestMapping("/list-san-pham")
//    public String listsanpham() {
//        return "shop/san-pham";
//    }
    @RequestMapping("/shop-san-pham/detail")
    public String detailsanpham() {
        return "shop/san-pham-detail";
    }
    @RequestMapping("/shop/about")
    public String about(){
        return "shop/about";
    }
    @RequestMapping("/shop/lien-he")
    public String contact(){
        return "shop/lien-he";
    }

}
