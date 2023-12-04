package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.service.GiamGiaService;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.ThongTinVanChuyenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.security.Principal;
import java.util.List;

@Controller
public class ThongTinVanChuyenController {
    @Autowired
    private ThongTinVanChuyenService thongTinVanChuyenService;

@Autowired
KhachHangRepo khachHangRepo;
    @RequestMapping("/thong-tin-van-chuyen")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String getAll(Model model,
                         @Param("keyword") String keyword, Authentication authentication){
        String username=authentication.getName();
        List<ThongTinVanChuyen> thongTinVanChuyenList =thongTinVanChuyenService.getAllByKhachHang(username);
        model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
        model.addAttribute("ttvc",new ThongTinVanChuyen());
        return"admin/thongtinvanchuyen";
    }
    @RequestMapping(value = "/thong-tin-van-chuyen-add",method = RequestMethod.POST)
    public String addThongTinVanChuyen(@Valid @ModelAttribute("ttvc") ThongTinVanChuyen thongTinVanChuyen,
                                       BindingResult result,
                                       Model model, Principal principal){
        String logname = principal.getName();
        KhachHang khachHang = khachHangRepo.findByUsername(logname);
        thongTinVanChuyen.setKhachHang(khachHang);
        Respon<ThongTinVanChuyen> respon = thongTinVanChuyenService.add(thongTinVanChuyen);
        List<ThongTinVanChuyen> thongTinVanChuyenList = thongTinVanChuyenService.getAll();
        model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
        model.addAttribute("ttvc",new ThongTinVanChuyen());
        model.addAttribute("repon",respon);
            return "redirect:/thong-tin-van-chuyen";


    }
    @RequestMapping("/thong-tin-van-chuyen/delete/{thongTinVanChuyenID}")
    public String delete(@PathVariable("thongTinVanChuyenID") Integer thongTinVanChuyenID){
        thongTinVanChuyenService.delete(thongTinVanChuyenID);
        return "redirect:/thong-tin-van-chuyen";
    }
    @RequestMapping("/thong-tin-van-chuyen-view-update/{thongTinVanChuyenID}")
    public String viewUpdate(@PathVariable("thongTinVanChuyenID") Integer thongTinVanChuyenID
            ,Model model){

        ThongTinVanChuyen thongTinVanChuyen = thongTinVanChuyenService.detail(thongTinVanChuyenID);
        List<ThongTinVanChuyen> thongTinVanChuyenList = thongTinVanChuyenService.getAll();
        model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
        model.addAttribute("ttvc",thongTinVanChuyen);
        return "admin/thongtinvanchuyen-update";
    }
    @RequestMapping(value = "/thong-tin-van-chuyen/update/{thongTinVanChuyenID}",method = RequestMethod.POST)
    public String update(@PathVariable("thongTinVanChuyenID") Integer thongTinVanChuyenID
            ,ThongTinVanChuyen thongTinVanChuyen,Model model){
        Respon<ThongTinVanChuyen> respon = thongTinVanChuyenService.update(thongTinVanChuyenID,thongTinVanChuyen);
        model.addAttribute("repon",respon);
        return "redirect:/thong-tin-van-chuyen/page";
    }
    @RequestMapping("/thong-tin-van-chuyen/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<ThongTinVanChuyen> page1 = thongTinVanChuyenService.getPage(page,size);
        List<ThongTinVanChuyen> thongTinVanChuyenList =page1.getContent();
        List<ThongTinVanChuyen> thongTinVanChuyenList1 = thongTinVanChuyenService.getAll();
        if(keyword !=null){
            thongTinVanChuyenList    = this.thongTinVanChuyenService.findDiaChi(keyword);
        }
        int totalItems = thongTinVanChuyenList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
        model.addAttribute("ttvc",new ThongTinVanChuyen());
        return "admin/thongtinvanchuyen";

    }
    @RequestMapping("/thong-tin-van-chuyen/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<ThongTinVanChuyen> thongTinVanChuyenList = thongTinVanChuyenService.findDiaChi(keyword);
        model.addAttribute("ttvc",thongTinVanChuyenList);
        return "admin/thongtinvanchuyen";
    }
}
