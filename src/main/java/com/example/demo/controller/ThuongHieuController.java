package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.ThuongHieuService;
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
public class ThuongHieuController {
   @Autowired
    ThuongHieuService thuongHieuService;
    @GetMapping("/thuong-hieu")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAll(Model model) {
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("listThuongHieu",thuongHieuList);
        model.addAttribute("th",new ThuongHieu());
        return "sanpham/thuonghieu";
    }
    @RequestMapping(value = "/thuong-hieu-add",method = RequestMethod.POST)
    public String addthuonghieu(@Valid @ModelAttribute("th") ThuongHieu thuongHieu, BindingResult result, Model model){

        thuongHieuService.add(thuongHieu);
        return "redirect:/thuong-hieu/page";
    }
    @RequestMapping("/thương-hieu/delete/{thuongHieuID}")
    public String delete(@PathVariable("thuongHieuID") Integer thuongHieuID){
        thuongHieuService.delete(thuongHieuID);
        return "redirect:/thuong-hieu/page";
    }
    @RequestMapping("/thuong-hieu-view-update/{thuongHieuID}")
    public String viewUpdate(@PathVariable("thuongHieuID") Integer thuongHieuID,Model model){
        ThuongHieu thuongHieu = thuongHieuService.detail(thuongHieuID);
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        model.addAttribute("listThuongHieu",thuongHieuList);
        model.addAttribute("th",thuongHieu);
        return "sanpham/thuonghieu-update";
    }
    @RequestMapping(value = "/thuong-hieu/update/{thuongHieuID}",method = RequestMethod.POST)
    public String update(@PathVariable("thuongHieuID") Integer thuongHieuID,ThuongHieu thuongHieu,Model model){
       Respon<ThuongHieu>respon= thuongHieuService.update(thuongHieuID,thuongHieu);
       model.addAttribute("repon",respon);
        return "redirect:/thuong-hieu/page";
    }
    @RequestMapping("/thuong-hieu/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<ThuongHieu> thuongHieuList = thuongHieuService.findTen(keyword);
        model.addAttribute("th",thuongHieuList);
        return "sanpham/thuonghieu";
    }
    @RequestMapping("/thuong-hieu/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<ThuongHieu> page1 = thuongHieuService.getPage(page,size);
        List<ThuongHieu> thuongHieuList =page1.getContent();
        List<ThuongHieu> thuongHieuList1 = thuongHieuService.getAll();
        if(keyword !=null){
            thuongHieuList     = this.thuongHieuService.findTen(keyword);
        }
        int totalItems = thuongHieuList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listThuongHieu",thuongHieuList);
        model.addAttribute("th",new ThuongHieu());
        return "sanpham/thuonghieu";

    }
}
