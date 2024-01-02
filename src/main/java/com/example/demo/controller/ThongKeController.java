package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Controller
public class ThongKeController {
    @Autowired
    private ThongKeService thongKeService;

    @GetMapping("/thongke")
    public String ThongKe(Model model, @RequestParam(name = "selectedDate", required = false) LocalDate selectedDate) {
        if (selectedDate == null) {
            selectedDate = LocalDate.now();
            return "redirect:/thongke?selectedDate=" + selectedDate;
        }

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

        Float totalTongTien = thongKeService.calculateTotalTongTien(trangThai);
        model.addAttribute("totalTongTien",totalTongTien);

        List<Object[]> totalQuantityByMonth = thongKeService.getTotalQuantityByMonthInYear2023(selectedDate);
        model.addAttribute("totalQuantityByMonth", totalQuantityByMonth);

        List<Object[]> getTotalRevenueForCurrentMonth = thongKeService.getTotalRevenueForCurrentMonth();
        model.addAttribute("getTotalRevenueForCurrentMonth",getTotalRevenueForCurrentMonth);

        Long totalQuantity = thongKeService.gettotalQuantity();
        model.addAttribute("totalQuantity",totalQuantity);


        long countOrdersByStatus = thongKeService.countOrdersByStatus();
        model.addAttribute("ordersByStatus", countOrdersByStatus);
        long countOrdersByStatus1 = thongKeService.countOrdersByStatus1();
        model.addAttribute("ordersByStatus1", countOrdersByStatus1);
        long countOrdersByStatus2 = thongKeService.countOrdersByStatus2();
        model.addAttribute("ordersByStatus2", countOrdersByStatus2);
        long countOrdersByStatus3 = thongKeService.countOrdersByStatus3();
        model.addAttribute("ordersByStatus3", countOrdersByStatus3);
        long countOrdersByStatus4 = thongKeService.countOrdersByStatus4();
        model.addAttribute("ordersByStatus4", countOrdersByStatus4);
        long countOrdersByStatus5 = thongKeService.countOrdersByStatus5();
        model.addAttribute("ordersByStatus5", countOrdersByStatus5);

        List<Object[]> totalRevenueByMonth = thongKeService.getTotalRevenueByMonthInYear2023();
        model.addAttribute("totalRevenueByMonth", totalRevenueByMonth);
        model.addAttribute("selectedDate", selectedDate);

            List<Object[]> topProducts = thongKeService.getTopProducts();
            model.addAttribute("topProducts",topProducts);
            return "admin/thong-ke";

    }
}
