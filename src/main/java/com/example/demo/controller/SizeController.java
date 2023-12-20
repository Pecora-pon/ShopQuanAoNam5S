package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.Size;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.SizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class SizeController {
    @Autowired
    SizeService sizeService;
    @GetMapping("/size")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAll(Model model){
        List<Size> sizeList=sizeService.getAll();
        model.addAttribute("listSize",sizeList);
        model.addAttribute("si",new Size());
        return "sanpham/size";
    }
    @RequestMapping(value = "/size-add",method = RequestMethod.POST)
    public String addMauSac(@Valid @ModelAttribute("si") Size size, BindingResult result,Model model,RedirectAttributes redirectAttributes){
        Respon<Size>respon=sizeService.add(size);
        List<Size> sizeList=sizeService.getAll();
        model.addAttribute("listSize",sizeList);
        model.addAttribute("si",new Size());
        redirectAttributes.addFlashAttribute("repon",respon);
        return "redirect:/size/page";
    }
    @RequestMapping("/size/delete/{sizeID}")
    public String deletesd(@PathVariable("sizeID") Integer sizeID){
        sizeService.delete(sizeID);
        return "redirect:/size/page";
    }
    @RequestMapping("/size-view-update/{sizeID}")
    public String delete(@PathVariable("sizeID")Integer sizeID,Model model){
        Size size=sizeService.detail(sizeID);
        List<Size> sizeList=sizeService.getAll();
        model.addAttribute("listSize",sizeList);
        model.addAttribute("si",size);
        return "sanpham/size-update";
    }
    @RequestMapping(value = "/size/update/{sizeID}",method = RequestMethod.POST)
    public String update(@PathVariable("sizeID") Integer sizeID, Size size, Model model, RedirectAttributes redirectAttributes){
       Respon<Size>respon= sizeService.update(sizeID,size);
       redirectAttributes.addFlashAttribute("repon",respon);
        return "redirect:/size/page";
    }
    @RequestMapping("/size/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<Size> sizeList = sizeService.findSize(keyword);
        model.addAttribute("listSize",sizeList);
        model.addAttribute("si",new Size());
        return "sanpham/size";
    }
    @RequestMapping("/size/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<Size> page1 = sizeService.getPage(page,size);
        List<Size> sizeList =page1.getContent();
        List<Size> sizeList1 = sizeService.getAll();
        if(keyword !=null){
            sizeList     = this.sizeService.findSize(keyword);
        }
        int totalItems = sizeList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listSize",sizeList);
        model.addAttribute("si",new Size());
        return "sanpham/size";

    }
}
