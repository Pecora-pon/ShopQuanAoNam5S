package com.example.demo.controller;


import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.SanPhamService;
import com.example.demo.servicesecuritykh.KhService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhService khService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SanPhamService sanPhamService;
    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại.");
        }
        return "admin/login";
}

    @GetMapping("/non-find")
    public String fail2(Model model){
       return "error/404";
    }
    @GetMapping("/invoice")
    public String invoce(){
        return "shop/invoice";
    }


    @GetMapping("/that-bai")
    public String thatbai(){
        return "shop/thatbai";
    }
    @GetMapping("/shop/blog")
    public String blog(){
        return "shop/blog";
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
    public String mainshop(Model model) {
        List<SanPham> sanPhams = sanPhamService.getTop4SanPhamByGiaThapNhat();
                model.addAttribute("listSanPham4", sanPhams);
                model.addAttribute("sp", new SanPham());
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
    public String showResetPasswordForm(@ModelAttribute("kh") KhachHang khachHang, @PathVariable("token") String token, Model model) {
        // Kiểm tra xem token đã được sử dụng hay chưa
        if (khService.isResetPasswordTokenUsed(token)) {
            // Nếu đã sử dụng, chuyển hướng hoặc thông báo lỗi
            return "error/rspw"; // Điều hướng đến trang thông báo token đã hết hạn hoặc không hợp lệ
        }

        // Nếu chưa sử dụng, hiển thị form đặt lại mật khẩu
        return "admin/reset_password_form";
    }


    @RequestMapping(value = "/reset_password/{token}", method = RequestMethod.POST)
    public String processResetPassword(@ModelAttribute("kh") KhachHang khachHang, @PathVariable("token") String token,
                                       @RequestParam("password") String password, Model model) {
        KhachHang khachHang1 = khService.getByResetPasswordToken(token);
        Respon<KhachHang> respon = khService.updatePassword(khachHang1, password, token);

        // Đánh dấu token đã được sử dụng sau khi đặt lại mật khẩu thành công
        khService.markResetPasswordTokenAsUsed(token);

        model.addAttribute("repon", respon);
        return "error/thanhcong";
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
    @PostMapping("/shop/lien-he")
    public String contactt(@RequestParam("name")String name,
                           @RequestParam("email")String email,
                           @RequestParam("content")String content, Model model, HttpSession session,RedirectAttributes redirectAttributes)throws MessagingException{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo("hieutcph27664@fpt.edu.vn");
        helper.setSubject("THÔNG TIN LIÊN HỆ");
        helper.setText("Xin chào "+name+","+"tôi muốn liên hệ với bạn qua email :"+email +" với nội dung : "+ content);
        mailSender.send(message);
        redirectAttributes.addFlashAttribute("successMessage", "Gửi tin nhắn thành công!");

        return "redirect:/shop/lien-he";
    }



}
