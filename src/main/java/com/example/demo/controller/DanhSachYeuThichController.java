package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.DanhSachYeuThichService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("danh-sach-yt")
public class DanhSachYeuThichController {

    @Autowired
    private DanhSachYeuThichService danhSachYeuThichService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    ShopService shopService;
    @Autowired
    KhachHangRepo khachHangRepo;

    @GetMapping("/hien-thi")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String hienthi(Model model, Authentication authentication){
        String username=authentication.getName();
        List<DanhSachSanPhamYeuThich> list = danhSachYeuThichService.findKhachHang_name(username);
        model.addAttribute("listSanPham", list);
        model.addAttribute("sp", new DanhSachYeuThichController());
        return "admin/danh-sach-yeu-thich/index";

    }

    @PostMapping("/add")
    public String add(@ModelAttribute("yt")DanhSachYeuThich danhSachYeuThich){
        List<KhachHang> listhk = khachHangService.getAll();
        danhSachYeuThichService.add(danhSachYeuThich);
        return "redirect:/danh-sach-yt/hien-thi";
    }

    @GetMapping("/delete/{danhSachYeuThichID}")
    public String delete(@PathVariable("danhSachYeuThichID") Integer DanhSachYTID,Model model){
        List<KhachHang> listkh = khachHangService.getAll();
        danhSachYeuThichService.delete(DanhSachYTID);
        model.addAttribute("listSanPham",listkh);
        return "redirect:/danh-sach-yt/hien-thi";
    }

    @RequestMapping("/danh-sach-yt/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<DanhSachYeuThich> nhanVienList = danhSachYeuThichService.findKhachHang(keyword);
        model.addAttribute("nv",nhanVienList);
        return "admin/danh-sach-yeu-thich/index";
    }



    @GetMapping("/them/{sanPhamID}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String them(@PathVariable("sanPhamID")UUID sanphamid, @ModelAttribute("sp") DanhSachYeuThich danhSach, Model model, Principal principal){
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        danhSach.setKhachHang(khachHang);
        DanhSachYeuThich danhSachYeuThich=danhSachYeuThichService.them(danhSach,sanphamid);
        model.addAttribute("sp",danhSachYeuThich);
        return "redirect:/list-san-pham/page";
    }
}
