package com.example.demo.controller;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ThongTinVanChuyen;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ThongTinVanChuyenController {
    @Autowired
    private ThongTinVanChuyenService thongTinVanChuyenService;

    @RequestMapping("/thong-tin-van-chuyen")
    public String getAll(Model model,
                         @Param("keyword") String keyword){

        List<ThongTinVanChuyen> thongTinVanChuyenList = thongTinVanChuyenService.getAll();
        model.addAttribute("listThongTinVanChuyen",thongTinVanChuyenList);
        model.addAttribute("ttvc",new ThongTinVanChuyen());
        return "admin/thongtinvanchuyen";
    }
    @RequestMapping(value = "/thong-tin-van-chuyen-add",method = RequestMethod.POST)
    public String addThongTinVanChuyen(@Valid @ModelAttribute("ttvc") ThongTinVanChuyen thongTinVanChuyen,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            return "admin/thongtinvanchuyen";
        }
        thongTinVanChuyenService.add(thongTinVanChuyen);
        return "redirect:/thong-tin-van-chuyen/page    ";
    }
    @RequestMapping("/thong-tin-van-chuyen/delete/{thongTinVanChuyenID}")
    public String delete(@PathVariable("thongTinVanChuyenID") Integer thongTinVanChuyenID){
        thongTinVanChuyenService.delete(thongTinVanChuyenID);
        return "redirect:/thong-tin-van-chuyen/page";
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
            ,ThongTinVanChuyen thongTinVanChuyen){
        thongTinVanChuyenService.update(thongTinVanChuyenID,thongTinVanChuyen);
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
