package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThongKeController {
    @Autowired
    private ThongKeService thongKeService;

    @GetMapping("/thongke")
    public String ThongKe(Model model) {
        int trangThai = 3;
        List<NhanVien> nhanViens = thongKeService.getAllNhanVien();
        long totalNhanVien = thongKeService.countNhanVien();

        model.addAttribute("nhanViens", nhanViens);
        model.addAttribute("totalNhanVien", totalNhanVien);


        List<SanPham> sanPhams = thongKeService.getAllSanPham();
        long totalSanPham = thongKeService.countSanPham();

        model.addAttribute("sanPhams", sanPhams);
        model.addAttribute("totalSanPham", totalSanPham);

        List<KhachHang> khachHangs = thongKeService.getAllKhachHang();
        long totalKhachHang = thongKeService.countKhachHang();

        model.addAttribute("khachHangs", sanPhams);
        model.addAttribute("totalKhachHang", totalKhachHang);

        double totalTongTien = thongKeService.calculateTotalTongTien(trangThai);
        model.addAttribute("totalTongTien",totalTongTien);

        List<Object[]> totalQuantityByMonth = thongKeService.getTotalQuantityByMonthInYear2023();
        model.addAttribute("totalQuantityByMonth", totalQuantityByMonth);

        List<Object[]> totalRevenueByMonth = thongKeService.getTotalRevenueByMonthInYear2023();
        model.addAttribute("totalRevenueByMonth", totalRevenueByMonth);
        return "admin/thong-ke";
    }

}
