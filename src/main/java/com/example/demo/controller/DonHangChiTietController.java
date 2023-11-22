package com.example.demo.controller;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.GiamGia;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.ThongTinVanChuyen;
import com.example.demo.service.DonHangChiTietService;
import com.example.demo.service.DonHangService;
import com.example.demo.service.GiamGiaService;
import com.example.demo.service.SanPhamService;
import jakarta.validation.Valid;
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
@RequestMapping("/don-hang-chi-tiet")
public class DonHangChiTietController {

    @Autowired
    private DonHangChiTietService donHangChiTietService;

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private GiamGiaService giamGiaService;

    @GetMapping("")
    public String hienthi(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet, Model model){
        List<DonHangChiTiet> list = donHangChiTietService.getAll();
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("listDH",listDH);
        model.addAttribute("listSP",listSP);
        model.addAttribute("listGG",listGG);
        return "admin/don-hang-chi-tiet/index";
    }

    @GetMapping("/delete/{donHangChiTietID}")
    public String delete(@PathVariable("donHangChiTietID") Integer donHangChiTietID){
        donHangChiTietService.delete(donHangChiTietID);
        return "redirect:/don-hang-chi-tiet";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("dhct")DonHangChiTiet donHangChiTiet){
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        donHangChiTietService.add(donHangChiTiet);
        return "redirect:/don-hang-chi-tiet";
    }

    @GetMapping("/{donHangChiTietID}")
    public String viewupdate(@PathVariable("donHangChiTietID") Integer donHangChiTietID,Model model){
        DonHangChiTiet dhct = donHangChiTietService.detail(donHangChiTietID);
        List<DonHangChiTiet> list = donHangChiTietService.getAll();
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("listDH",listDH);
        model.addAttribute("listSP",listSP);
        model.addAttribute("listGG",listGG);
        model.addAttribute("dhct",dhct);
        return "admin/don-hang-chi-tiet/view-update";
    }

    @GetMapping("/don-hang-chi-tiet/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DonHangChiTiet> page1 = donHangChiTietService.getPage(page,size);
        List<DonHangChiTiet> list =page1.getContent();
        List<DonHangChiTiet> list1 = donHangChiTietService.getAll();
        if(keyword !=null){
            list1     = this.donHangChiTietService.findTenKhachHang(keyword);
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
        return "admin/don-hang-chi-tiet";

    }

    @PostMapping("/update/{donHangChiTietID}")
    public String update(@Valid @ModelAttribute("dhct")DonHangChiTiet donHangChiTiet){
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        donHangChiTietService.add(donHangChiTiet);
        return "redirect:/don-hang-chi-tiet";
    }

}