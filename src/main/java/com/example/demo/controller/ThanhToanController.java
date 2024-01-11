package com.example.demo.controller;

import com.example.demo.config.DonHangPDF;
import com.example.demo.config.VNPayService;
import com.example.demo.entity.*;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.*;
import com.example.demo.service.impl.GiamGiaChiTietServiceImpl;
import com.example.demo.service.impl.GioHangImpl;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class ThanhToanController {
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    KhachHangRepo khachHangRepo;
    @Autowired
    ThanhToanService thanhToanService;
    @Autowired
    GiamGiaService giamGiaService;
    @Autowired
    DonHangService donHangService;
   @Autowired
   SanPhamService sanPhamService;
    @Autowired
    ThongTinVanChuyenService thongTinVanChuyenService;
    @Autowired
    JavaMailSender mailSender;

    @GetMapping("/thanh-toan")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String thanhtoan(Principal principal, Model model){
        String logname= principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        List<GiamGia>giamGiaList=giamGiaService.getAll();
        List<ThongTinVanChuyen>thongTinVanChuyenList=thongTinVanChuyenService.getAll();
        model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
        model.addAttribute("listGiamGia",giamGiaList);
        model.addAttribute("tt",khachHang);
        return "shop/thanh-toan";
    }
//    @GetMapping("/tt")
//    public String tt(){
//        return "shop/thong-bao";
//    }
   @PostMapping("/list-gh")
   @PreAuthorize("hasAuthority('ROLE_USER')")
    public String detail(@RequestParam(value = "selectedItems",required = false) List<Integer> gioHangID, Authentication authentication, @RequestParam Map<String, String> params, Model model, Principal principal){
       List<GioHang>gioHangList= thanhToanService.detail(gioHangID,params);
       String username=authentication.getName();
       String logname= principal.getName();
       KhachHang khachHang=khachHangRepo.findByUsername(logname);
       List<GiamGia>giamGiaList=giamGiaService.getAll();
       List<ThongTinVanChuyen>thongTinVanChuyenList=thongTinVanChuyenService.getAllByKhachHang(username);
       List<SanPham> sanPhamList=sanPhamService.getTop4SanPhamByGiaThapNhat();
       model.addAttribute("listSanPham",sanPhamList);
       model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
       model.addAttribute("tt",khachHang);
       model.addAttribute("listGiamGia",giamGiaList);
       model.addAttribute("listGioHang",gioHangList);
        return "shop/thanh-toan";
   }
   @PostMapping("/themmoi")
    public String themmoi(@RequestParam("email")String email, @RequestParam("hoTen")String hoTen, @ModelAttribute("t") DonHang donHang, @RequestParam("gioHangID[]")List<Integer>  giohangID, @RequestParam("amount") float tt,@RequestParam("trangThai")int trang, Model model, Principal principal, HttpServletResponse response)throws MessagingException, IOException {
        String logname=principal.getName();
//       response.setContentType("application/pdf");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormatter.format(new Date());
//
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
//        response.setHeader(headerKey, headerValue);
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        donHang.setKhachHang(khachHang);
       DonHang donHang1= thanhToanService.themmoi(donHang,giohangID,tt,trang);
        model.addAttribute("t",donHang1);
//        DonHangPDF donHangPDF = new DonHangPDF();
//       byte[] pdfDonHang = donHangPDF.exportpdf(donHang);
       String donhanggg="http://localhost:8080/detail6/"+donHang.getDonHangID();
       MimeMessage message = mailSender.createMimeMessage();
       MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
       helper.setTo(email);
       String subject = "Bạn đã đặt hàng thành công";

       String content = "<p>Xin chào "+hoTen+",</p>" + "<p>Bạn đã đặt hàng thành công</p>"
               + "<p>Nhấp vào liên kết bên dưới để xem hóa đơn của bạn:</p>" + "<p><a href=\"" + donhanggg
               + "\">Xem đơn hàng</a></p>" + "<br>"
               + "<p>Cảm ơn bạn đã mua sản phẩm bên 5SFashion</p> ";

       helper.setSubject(subject);
       helper.setText(content,true);
//       helper.addAttachment("donhang_" + currentDateTime + ".pdf",new ByteArrayResource(pdfDonHang));

       mailSender.send(message);
        return "shop/thong-bao";
   }
   @GetMapping("/themngay/{tenSanPham}/{hinhAnhURL}/{sizeID}/{mauSacID}")
   @PreAuthorize("hasAuthority('ROLE_USER')")
    public String detail1(@PathVariable("tenSanPham")String ten,@PathVariable("hinhAnhURL")String anh,@PathVariable("sizeID")int size,@PathVariable("mauSacID")int mausac,@RequestParam(value = "soLuongDat",defaultValue = "1")int sl, Model model,Principal principal,Authentication authentication){
        SanPham sanPham=thanhToanService.deltail1(ten,anh,size,mausac,sl);
        List<SanPham>sanPhamList=sanPhamService.getAll();
       String username=authentication.getName();
        String logname= principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        List<GiamGia>giamGiaList=giamGiaService.getAll();
       List<ThongTinVanChuyen>thongTinVanChuyenList=thongTinVanChuyenService.getAllByKhachHang(username);
       model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
       model.addAttribute("listGiamGia",giamGiaList);
       model.addAttribute("tt",khachHang);
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("soLuongDat",sl);
        model.addAttribute("sp",sanPham);
        return "shop/thanh-toann";
   }
//    @GetMapping("/themngay/{sanPhamID}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String detail1(@PathVariable("sanPhamID")UUID ten,@RequestParam(value = "soLuongDat",defaultValue = "1")int sl, Model model,Principal principal,Authentication authentication){
//        SanPham sanPham=thanhToanService.deltail1(ten,sl);
//        List<SanPham>sanPhamList=sanPhamService.getAll();
//        String username=authentication.getName();
//        String logname= principal.getName();
//        KhachHang khachHang=khachHangRepo.findByUsername(logname);
//        List<GiamGia>giamGiaList=giamGiaService.getAll();
//        List<ThongTinVanChuyen>thongTinVanChuyenList=thongTinVanChuyenService.getAllByKhachHang(username);
//        model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
//        model.addAttribute("listGiamGia",giamGiaList);
//        model.addAttribute("tt",khachHang);
//        model.addAttribute("listSanPham",sanPhamList);
//        model.addAttribute("soLuongDat",sl);
//        model.addAttribute("sp",sanPham);
//        return "shop/thanh-toann";
//    }
    @PostMapping("/themmoiny")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String themmoinay(@RequestParam("email")String email, @RequestParam("hoTen")String hoTen,@ModelAttribute("t") DonHang donHang,@RequestParam("sanPhamID") UUID id,@RequestParam("soLuongDat")int sl,@RequestParam("amount")float tt,@RequestParam("trangThai")int trang, Model model,Principal principal)throws MessagingException{
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        donHang.setKhachHang(khachHang);
        DonHang donHang1= thanhToanService.themmoingay(donHang,id,sl,tt,trang);
        model.addAttribute("t",donHang1);
        String donhanggg="http://localhost:8080/detail6/"+donHang.getDonHangID();
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"UTF-8");
        helper.setTo(email);
        String subject = "Bạn đã đặt hàng thành công";

        String content = "<p>Xin chào "+hoTen+",</p>" + "<p>Bạn đã đặt hàng thành công</p>"
                + "<p>Nhấp vào liên kết bên dưới để xem hóa đơn của bạn:</p>" + "<p><a href=\"" + donhanggg
                + "\">Xem đơn hàng</a></p>" + "<br>"
                + "<p>Cảm ơn bạn đã mua sản phẩm bên 5SFashion</p> ";

        helper.setSubject(subject);
        helper.setText(content,true);
//       helper.addAttachment("donhang_" + currentDateTime + ".pdf",new ByteArrayResource(pdfDonHang));

        mailSender.send(message);
        return "shop/thong-bao";
    }

//    @GetMapping("/thanh-toan-that-bai")
//    public String khongthanhcong(Model model) {
//        return "shop/thatbai";
//
//    }
}
