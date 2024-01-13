package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ThongKeService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Controller
public class ThongKeController {
    @Autowired
    private ThongKeService thongKeService;

    @Autowired
    private SanPhamService sanPhamService;


    @GetMapping("/thongke")
    public String ThongKe(RedirectAttributes redirectAttributes,Model model, @RequestParam(name = "selectedDate", required = false) LocalDate selectedDate) {
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

        //th
        List<Object[]> danhSachSapHetHangAll = (List<Object[]>) model.asMap().get("ListDanhSachSapHetHang15");
        Integer soLuongTon = 25;
        List<Object[]> listDanhSachSapHetHang15 = sanPhamService.danhSachHangSapHet(soLuongTon);
        model.addAttribute("soLuongTon", soLuongTon);

        if (danhSachSapHetHangAll == null){
            model.addAttribute("ListDanhSachSapHetHang15",listDanhSachSapHetHang15);
        }else{
            model.addAttribute("ListDanhSachSapHetHang15",danhSachSapHetHangAll);
        }
            List<Object[]> topProducts = thongKeService.getTopProducts();
            model.addAttribute("topProducts",topProducts);
            return "admin/thong-ke";

    }

    //b
    @PostMapping("/thongke/sapHetHang")
    public String countSapHetHang(
            @RequestParam(name = "soLuongTon", required = false) Integer soLuongTon,
            @RequestParam(name = "outputFormat", defaultValue = "table") String outputFormat,@RequestParam(name = "selectedDate", required = false) LocalDate selectedDate,
            Model model,  // Use Model to add attributes for the view
            RedirectAttributes redirectAttributes,
            HttpServletResponse response) {
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

        //th
//        List<Object[]> danhSachSapHetHangAll = (List<Object[]>) model.asMap().get("ListDanhSachSapHetHang15");
//        Integer soLuongTon = 200;
//        List<Object[]> listDanhSachSapHetHang15 = sanPhamService.danhSachHangSapHet(soLuongTon);
//
//        if (danhSachSapHetHangAll == null){
//            model.addAttribute("ListDanhSachSapHetHang15",listDanhSachSapHetHang15);
//        }else{
//            model.addAttribute("ListDanhSachSapHetHang15",danhSachSapHetHangAll);
//        }
        List<Object[]> topProducts = thongKeService.getTopProducts();
        model.addAttribute("topProducts",topProducts);
        List<Object[]> danhSachSapHetHang = sanPhamService.danhSachHangSapHet(soLuongTon);
        model.addAttribute("soLuongTon", soLuongTon);
        model.addAttribute("ListDanhSachSapHetHang15", danhSachSapHetHang);
//        model.addAttribute("danhSachSapHetHang", danhSachSapHetHang);

        if ("excel".equals(outputFormat)) {
            // Export to Excel
            response.setHeader("Content-Disposition", "attachment; filename=SapHetHang.xlsx");
            exportToExcel(response, danhSachSapHetHang);
            return null;  // Returning null to indicate that the response is already handled
        } else {
            return "admin/thong-ke";  // Return the JSP view name without redirect
        }
    }

    private void exportToExcel(HttpServletResponse response, List<Object[]> listSapHetHang) {
        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("SapHetHang");

            // Create header row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("STT");
            header.createCell(1).setCellValue("Sản phẩm");
            header.createCell(2).setCellValue("Kích cỡ");
            header.createCell(3).setCellValue("Màu sắc");
            header.createCell(4).setCellValue("Chất liệu");
            header.createCell(5).setCellValue("Thương hiệu");
            header.createCell(6).setCellValue("Số Lượng");

            // Populate data rows
            int rowNum = 1;
            for (Object[] row : listSapHetHang) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(rowNum - 1); // STT
                for (int i = 1; i < row.length + 1; i++) {
                    Cell cell = dataRow.createCell(i);
                    cell.setCellValue(String.valueOf(row[i - 1]));
                }
            }

            // Write the workbook to the response output stream
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.close();

        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
