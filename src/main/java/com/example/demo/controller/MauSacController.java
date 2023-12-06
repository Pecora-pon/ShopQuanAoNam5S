package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.Size;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MauSacController {
    @Autowired
    MauSacService mauSacService;
    @GetMapping("/mau-sac")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAll(Model model){
        List<MauSac>mauSacList=mauSacService.getAll();
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("ms",new MauSac());
        return "sanpham/mausac";
    }
    @RequestMapping(value = "/mau-sac-add",method = RequestMethod.POST)
    public String addMauSac(@Valid @ModelAttribute("ms") MauSac mauSac, BindingResult result,Model model){
        Respon<MauSac> respon=mauSacService.add(mauSac);
        List<MauSac>mauSacList=mauSacService.getAll();
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("ms",new MauSac());
        model.addAttribute("repon",respon);
        return "sanpham/mausac";
    }
    @RequestMapping("/mau-sac/delete/{mauSacID}")
    public String delete(@PathVariable("mauSacID") Integer mauSacID,Model model){
//        List<MauSac>mauSacList=mauSacService.getAll();
//        model.addAttribute("listMauSac",mauSacList);
        mauSacService.delete(mauSacID);
        return "redirect:/mau-sac/page";
    }
    @RequestMapping("/mau-sac-view-update/{mauSacID}")
    public String update1(@PathVariable("mauSacID")Integer mauSacID,Model model){
        MauSac mauSac=mauSacService.detail(mauSacID);
        List<MauSac> mauSacList=mauSacService.getAll();
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("ms",mauSac);
        return "sanpham/mausac-update";
    }
    @RequestMapping(value = "/mau-sac/update/{mauSacID}",method = RequestMethod.POST)
    public String update(@PathVariable("mauSacID") Integer mauSacID, MauSac mauSac,Model model){
       Respon<MauSac>respon= mauSacService.update(mauSacID,mauSac);
        List<MauSac>mauSacList=mauSacService.getAll();
        model.addAttribute("listMauSac",mauSacList);
       model.addAttribute("repon",respon);
        return "redirect:/mau-sac/page";
    }
    @RequestMapping("/mau-sac/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<MauSac> mauSacList = mauSacService.findTen(keyword);
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("ms",new Size());
        return "sanpham/mausac";
    }
    @RequestMapping("/mau-sac/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<MauSac> page1 = mauSacService.getPage(page,size);
        List<MauSac> mauSacList =page1.getContent();
        List<MauSac> mauSacList1 = mauSacService.getAll();
        if(keyword !=null){
            mauSacList     = this.mauSacService.findTen(keyword);
        }
        int totalItems = mauSacList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("ms",new MauSac());
        return "sanpham/mausac";

    }
}
