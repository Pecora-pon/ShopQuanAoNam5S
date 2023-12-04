package com.example.demo.controller;


import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.KhachHangService;
import com.example.demo.servicesecuritykh.KhService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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








    @GetMapping("/trang-chu/sign-up")
    public String sigunup(@ModelAttribute("kh")KhachHang khachHang) {
        return "admin/dangky";
    }

    @PostMapping("/trang-chu/sign-up")
    public String sigunupadd(@RequestParam("email")String email,
                             @RequestParam("hoTen") String hoTen,
                             @RequestParam("username")String username,
                             @RequestParam("password")String password, @ModelAttribute("kh")KhachHang khachHang, Model model, HttpServletRequest request)throws MessagingException {
        Respon<KhachHang> respon=khService.addKH(khachHang,request);
        model.addAttribute("repon",respon);
        return "admin/dangky";
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

    @GetMapping("/forgot_password")
    public String pass(@ModelAttribute("kh") KhachHang khachHang) {

        return "admin/doimatkhau";
    }

    @PostMapping("/forgot_password")
    public String passforgot(@ModelAttribute("kh")KhachHang khachHang, Model model)throws MessagingException {
        Respon<KhachHang> respon=khService.ForgotPasswordKH(khachHang);
        model.addAttribute("repon",respon);
        return "admin/doimatkhau";
    }

    @RequestMapping("/reset_password/{token}")
    public String showResetPasswordForm(@ModelAttribute("kh")KhachHang khachHang,@PathVariable("token")String token, Model model) {
        return "admin/reset_password_form";
    }

    @RequestMapping(value = "/reset_password/{token}",method = RequestMethod.POST)
    public String processResetPassword(@ModelAttribute("kh")KhachHang khachHang,@PathVariable("token")String token,
                                        @RequestParam("password") String password, Model model) {
         KhachHang khachHang1 = khService.getByResetPasswordToken(token);
        Respon<KhachHang> respon = khService.updatePassword(khachHang1,password,token);
        model.addAttribute("repon",respon);
        return "admin/reset_password_form";
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
