package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
