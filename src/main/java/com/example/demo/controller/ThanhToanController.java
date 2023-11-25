package com.example.demo.controller;

import com.example.demo.config.VNPayService;
import com.example.demo.entity.*;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.*;
import com.example.demo.service.impl.GiamGiaChiTietServiceImpl;
import com.example.demo.service.impl.GioHangImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
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
    public String detail(@RequestParam(value = "selectedItems",required = false) List<Integer> gioHangID,Model model,Principal principal){
       List<GioHang>gioHangList= thanhToanService.detail(gioHangID);
       String logname= principal.getName();
       KhachHang khachHang=khachHangRepo.findByUsername(logname);
       List<GiamGia>giamGiaList=giamGiaService.getAll();
       List<ThongTinVanChuyen>thongTinVanChuyenList=thongTinVanChuyenService.getAll();
       model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
       model.addAttribute("tt",khachHang);
       model.addAttribute("listGiamGia",giamGiaList);
       model.addAttribute("listGioHang",gioHangList);
        return "shop/thanh-toan";
   }
   @PostMapping("/themmoi")
    public String themmoi(@ModelAttribute("t") DonHang donHang,@RequestParam("gioHangID[]") List<Integer> giohangID,Model model,Principal principal){
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        donHang.setKhachHang(khachHang);
       DonHang donHang1= thanhToanService.themmoi(donHang,giohangID);
        model.addAttribute("t",donHang1);
        return "shop/thong-bao";
   }
   @GetMapping("/themngay/{sanPhamID}")
   @PreAuthorize("hasAuthority('ROLE_USER')")
    public String detail1(@PathVariable("sanPhamID")UUID id,Model model,Principal principal){
        SanPham sanPham=thanhToanService.deltail1(id);
        List<SanPham>sanPhamList=sanPhamService.getAll();
        String logname= principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        List<GiamGia>giamGiaList=giamGiaService.getAll();
       List<ThongTinVanChuyen>thongTinVanChuyenList=thongTinVanChuyenService.getAll();
       model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
       model.addAttribute("listGiamGia",giamGiaList);
       model.addAttribute("tt",khachHang);
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("sp",sanPham);
        return "shop/thanh-toann";
   }
    @PostMapping("/themmoiny")
    public String themmoinay(@ModelAttribute("t") DonHang donHang,@RequestParam("sanPhamID") UUID id,Model model,Principal principal){
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        donHang.setKhachHang(khachHang);
        DonHang donHang1= thanhToanService.themmoingay(donHang,id);
        model.addAttribute("t",donHang1);
        return "shop/thong-bao";
    }

//    @GetMapping("/thanh-toan-that-bai")
//    public String khongthanhcong(Model model) {
//        return "shop/thatbai";
//
//    }
}
