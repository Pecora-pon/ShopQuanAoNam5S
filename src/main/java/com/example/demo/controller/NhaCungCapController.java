package com.example.demo.controller;

import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.NhaCungCapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class NhaCungCapController {
@Autowired
    NhaCungCapService nhaCungCapService;
    @RequestMapping("/nha-cung-cap")
    public String getAll(Model model) {
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll();
        model.addAttribute("listNhaCungCap",nhaCungCapList);
        model.addAttribute("ncc",new NhaCungCap());
        return "sanpham/nhacungcap";
    }
    @RequestMapping(value = "/nha-cung-cap-add",method = RequestMethod.POST)
    public String addNhaCC(@Valid @ModelAttribute("ncc") NhaCungCap nhaCungCap, BindingResult result, Model model){
        Respon<NhaCungCap> respon=nhaCungCapService.add(nhaCungCap);
        model.addAttribute("repon",respon);
        return "sanpham/nhacungcap";
    }
    @RequestMapping("/nha-cung-cap/delete/{nhaCungCapID}")
    public String delete(@PathVariable("nhaCungCapID") Integer nhaCungCapID){
        nhaCungCapService.delete(nhaCungCapID);
        return "redirect:/nha-cung-cap";
    }
    @RequestMapping("/nha-cung-cap-view-update/{nhaCungCapID}")
    public String viewUpdate(@PathVariable("nhaCungCapID") Integer nhaCungCapID,Model model){
        NhaCungCap nhaCungCap = nhaCungCapService.detail(nhaCungCapID);
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll();
        model.addAttribute("listNhaCungCap",nhaCungCapList);
        model.addAttribute("ncc",nhaCungCap);
        return "sanpham/nhacungcap-update";
    }
    @RequestMapping(value = "/nha-cung-cap/update/{nhaCungCapID}",method = RequestMethod.POST)
    public String update(@PathVariable("nhaCungCapID") Integer nhaCungCapID,NhaCungCap nhaCungCap,Model model){
       Respon<NhaCungCap> respon= nhaCungCapService.update(nhaCungCapID,nhaCungCap);
       model.addAttribute("repon",respon);
        return "redirect:/nha-cung-cap/page";
    }
    @RequestMapping("/nha-cung-cap/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<NhaCungCap> page1 = nhaCungCapService.getPage(page,size);
        List<NhaCungCap> nhaCungCapList =page1.getContent();
        List<NhaCungCap> nhaCungCapList1 = nhaCungCapService.getAll();
        if(keyword !=null){
            nhaCungCapList     = this.nhaCungCapService.findby(keyword);
        }
        int totalItems = nhaCungCapList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listNhaCungCap",nhaCungCapList);
        model.addAttribute("nv",new NhanVien());
        return "sanpham/nhacungcap";

    }
}
