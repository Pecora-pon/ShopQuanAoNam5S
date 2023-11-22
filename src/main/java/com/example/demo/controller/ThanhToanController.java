package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.*;
import com.example.demo.service.impl.GiamGiaChiTietServiceImpl;
import com.example.demo.service.impl.GioHangImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
    ThongTinVanChuyenService thongTinVanChuyenService;
    @GetMapping("/thanh-toan")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String thanhtoan(Principal principal, Model model){
        String logname= principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        List<GiamGia>giamGiaList=giamGiaService.getAll();
        List<ThongTinVanChuyen>thongTinVanChuyenList=thongTinVanChuyenService.getAll();
        model.addAttribute("listThongTinVC",thongTinVanChuyenList);
        model.addAttribute("listGiamGia",giamGiaList);
        model.addAttribute("tt",khachHang);
        return "shop/thanh-toan";
    }
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
        return "shop/thanh-toan";
   }
}
