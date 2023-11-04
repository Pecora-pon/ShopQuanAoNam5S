package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @RequestMapping("/trang-chu/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping("/trang-chu/sign-up")
    public String sigunup() {
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

    @RequestMapping("/doimatkhau")
    public String pass() {
        return "admin/doimatkhau";
    }

//    @RequestMapping("/gio-hang")
//    public String giohang() {
//        return "shop/gio-hang";
//    }

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
