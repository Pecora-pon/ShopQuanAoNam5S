package com.example.demo.controller;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.GiamGia;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.ThongTinVanChuyen;
import com.example.demo.service.DonHangService;
import com.example.demo.service.GiamGiaService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.ThongTinVanChuyenService;
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
import java.util.UUID;

@Controller
@RequestMapping("/don-hang")
public class DonHangController {

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private ThongTinVanChuyenService thongTinVanChuyenService;

    @Autowired
    private GiamGiaService giamGiaService;

    @GetMapping("")
    public String hienthi(@ModelAttribute("dh") DonHang donHang, Model model){
        List<DonHang> list = donHangService.getAll();
        List<KhachHang> listKH = khachHangService.getAll();
        List<ThongTinVanChuyen> listTTVC = thongTinVanChuyenService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("listKH",listKH);
        model.addAttribute("listTTVC",listTTVC);
        model.addAttribute("listGG",listGG);
        return "admin/don-hang/index";
    }

    @GetMapping("/delete/{donHangID}")
    public String delete(@PathVariable("donHangID") UUID donHangID){
        donHangService.delete(donHangID);
        return "redirect:/don-hang";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dh")DonHang donHang){
        List<KhachHang> listKH = khachHangService.getAll();
        List<ThongTinVanChuyen> listTTVC = thongTinVanChuyenService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        donHangService.add(donHang);
        return "redirect:/don-hang";
    }

    @GetMapping("/view-update/{donHangID}")
    public String viewupdate(@PathVariable("donHangID") UUID donHangID,Model model){
        DonHang dh = donHangService.detail(donHangID);
        List<DonHang> list = donHangService.getAll();
        List<KhachHang> listKH = khachHangService.getAll();
        List<ThongTinVanChuyen> listTTVC = thongTinVanChuyenService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("listKH",listKH);
        model.addAttribute("listTTVC",listTTVC);
        model.addAttribute("listGG",listGG);
        model.addAttribute("dh",dh);
        return "admin/don-hang/view-update";
    }

    @GetMapping("/don-hang/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DonHang> page1 = donHangService.getPage(page,size);
        List<DonHang> list =page1.getContent();
        List<DonHang> list1 = donHangService.getAll();
        if(keyword !=null){
            list1     = this.donHangService.findTenKhachHang(keyword);
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
        model.addAttribute("dh",new DonHang());
        return "admin/don-hang";

    }

    @PostMapping("/update/{donHangID}")
    public String update(@ModelAttribute("dh")DonHang donHang){
        List<KhachHang> listKH = khachHangService.getAll();
        List<ThongTinVanChuyen> listTTVC = thongTinVanChuyenService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        donHangService.add(donHang);
        return "redirect:/don-hang";
    }

}
