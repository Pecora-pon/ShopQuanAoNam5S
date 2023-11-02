package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.ReviewNguoiDungService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("review")
public class ReviewNguoiDungController {

    @Autowired
    private ReviewNguoiDungService reviewNguoiDungService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private KhachHangService khachHangService;


    @GetMapping("/hien-thi")
    public String hienthi(@ModelAttribute("rv") ReviewNguoiDung reviewNguoiDung, Model model){
        List<ReviewNguoiDung> list = reviewNguoiDungService.getAll();
        List<SanPham> listsp = sanPhamService.getAll();
        List<KhachHang> listkh = khachHangService.getAll();
        model.addAttribute("list", list);
       model.addAttribute("listsp",listsp);
        model.addAttribute("listkh",listkh);
        return "admin/review-nguoi-dung/index";

    }
    @PostMapping("/add")
    public String add(@ModelAttribute("rv")ReviewNguoiDung reviewNguoiDung){
        List<KhachHang> listhk = khachHangService.getAll();
        List<SanPham> listsp = sanPhamService.getAll();
        reviewNguoiDungService.add(reviewNguoiDung);
        return "redirect:/review/hien-thi";
    }

    @GetMapping("/delete/{reviewID}")
    public String delete(@PathVariable("reviewID") Integer reviewID){
        List<KhachHang> listkh = khachHangService.getAll();
        List<SanPham> listsp = sanPhamService.getAll();
        reviewNguoiDungService.delete(reviewID);
        return "redirect:/review/hien-thi";
    }

    @GetMapping("/view-update/{reviewID}")
    public String viewUpdate(@PathVariable("reviewID") Integer reviewID
            ,Model model){
        ReviewNguoiDung reviewNguoiDung = reviewNguoiDungService.detail(reviewID);
        List<ReviewNguoiDung> nhanVienList = reviewNguoiDungService.getAll();
        List<KhachHang> listkh = khachHangService.getAll();
        List<SanPham> listsp = sanPhamService.getAll();
        model.addAttribute("listreview",nhanVienList);
        model.addAttribute("rv",reviewNguoiDung);
        model.addAttribute("listsp",listsp);
        model.addAttribute("listkh",listkh);
        return "admin/review-nguoi-dung/view-update";
    }
    @PostMapping("/update/{reviewID}")
    public String update(@ModelAttribute("rv")ReviewNguoiDung reviewNguoiDung){
        List<KhachHang> listkh = khachHangService.getAll();
        List<SanPham> listsp = sanPhamService.getAll();
        reviewNguoiDungService.add(reviewNguoiDung);
        return "redirect:/review/hien-thi";
    }
//    @RequestMapping("/review/hien-thi/page")
//    public String page(@RequestParam(defaultValue = "0") int page,
//                       @RequestParam(defaultValue = "3") int size,
//                       Model model,
//                       @Param("keyword") String keyword){
//        Page<ReviewNguoiDung> page1 = reviewNguoiDungService.getPage(page,size);
//        List<ReviewNguoiDung> nhanVienList =page1.getContent();
//        List<ReviewNguoiDung> nhanVienList1 = reviewNguoiDungService.getAll();
//        if(keyword !=null){
//            nhanVienList     = this.reviewNguoiDungService.findTenkhachHang(keyword);
//        }
//        int totalItems = nhanVienList1.size();
//        int itemsPerPage = size;
//        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
//        int currentPage = page;
//        model.addAttribute("currentPage",currentPage);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("itemsPerPage", itemsPerPage);
//        model.addAttribute("totalItems", totalItems);
//        model.addAttribute("listNhanVien",nhanVienList);
//        model.addAttribute("nv",new ReviewNguoiDung());
//        return "admin/review-nguoi-dung/index";
//
//    }
}
