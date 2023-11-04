package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

//    @Autowired
//    private ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienthi(@ModelAttribute("kh")KhachHang khachHang,Model model){
        List<KhachHang> list = khachHangService.getAll();
//        List<ChucVu> listCV = chucVuService.getAll();
        model.addAttribute("list",list);
//        model.addAttribute("listCV",listCV);
        return "admin/khach-hang/index";
    }

    @GetMapping("/delete/{khachHangId}")
    public String delete(@PathVariable("khachHangId") Integer khachHangId){
//        List<ChucVu> listCV = chucVuService.getAll();
        khachHangService.delete(khachHangId);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("kh")KhachHang khachHang){
//        List<ChucVu> listCV = chucVuService.getAll();
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/view-update/{khachHangId}")
    public String viewupdate(@PathVariable("khachHangId") Integer khachHangId,Model model){
        KhachHang kh = khachHangService.detail(khachHangId);
        List<KhachHang> list = khachHangService.getAll();
//        List<ChucVu> listCV = chucVuService.getAll();
        model.addAttribute("list",list);
//        model.addAttribute("listCV",listCV);
        model.addAttribute("kh",kh);
        return "admin/khach-hang/view-update";
    }

    @GetMapping("/khach-hang/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<KhachHang> page1 = khachHangService.getPage(page,size);
        List<KhachHang> list =page1.getContent();
        List<KhachHang> list1 = khachHangService.getAll();
        if(keyword !=null){
            list1     = this.khachHangService.findTenOrDiaChi(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("list",list);
        model.addAttribute("kh",new KhachHang());
        return "admin/khach-hang/index";

    }

    @PostMapping("/update/{khachHangId}")
    public String update(@ModelAttribute("kh")KhachHang khachHang){
//        List<ChucVu> listCV = chucVuService.getAll();
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

}
