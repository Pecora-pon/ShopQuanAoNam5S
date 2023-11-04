package com.example.demo.controller;


import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.GiamGiaRepo;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.service.GiamGiaService;
import jakarta.validation.Valid;
import org.hibernate.Session;
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
import java.util.Optional;

@Controller
public class GiamGiaController {
    @Autowired
    private GiamGiaService giamGiaService;
    @Autowired
    private GiamGiaRepo giamGiaRepo;
    @Autowired
    private NhanVienRepo nhanVienRepo;



    @RequestMapping("/giam-gia")
    public String getAll(Model model,
                         @Param("keyword") String keyword) {

        List<GiamGia> giamGiaList = giamGiaService.getAll();
        model.addAttribute("nv",nhanVienRepo.findAll());
        model.addAttribute("listGiamGia",giamGiaList);
        model.addAttribute("gg",new GiamGia());
        return "admin/giamgia";
    }
    @RequestMapping(value = "/giam-gia-add",method = RequestMethod.POST)
    public String addGiamGia(@Valid @ModelAttribute("nv") GiamGia giamGia,
                             BindingResult result,
                             Model model){
        model.addAttribute("nv",nhanVienRepo.findAll());

        giamGiaService.add(giamGia);
        return "redirect:/giam-gia/page";
    }
    @RequestMapping("/giam-gia/delete/{giamGiaID}")
    public String delete(@PathVariable("giamGiaID") Integer giamGiaID){
        giamGiaService.delete(giamGiaID);
        return "redirect:/giam-gia/page";
    }
    @RequestMapping("/giam-gia-view-update/{giamGiaID}")
    public String viewUpdate(@PathVariable("giamGiaID") Integer giamGiaID
            ,Model model){
        GiamGia giamGia = giamGiaService.detail(giamGiaID);
        List<GiamGia> giamGiaList = giamGiaService.getAll();
        model.addAttribute("nv",nhanVienRepo.findAll());
        model.addAttribute("listGiamGia",giamGiaList);
        model.addAttribute("gg",giamGia);
        return "admin/giamgia-update";
    }
    @RequestMapping(value = "/giam-gia/update/{giamGiaID}",method = RequestMethod.POST)
    public String update(@PathVariable("giamGiaID") Integer giamGiaID
            ,GiamGia giamGia){
       giamGiaService.update(giamGiaID,giamGia);
        return "redirect:/giam-gia/page";
    }
    @RequestMapping("/giam-gia/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<GiamGia> page1 = giamGiaService.getPage(page,size);
        List<GiamGia> giamGiaList =page1.getContent();
        List<GiamGia> giamGiaList1 = giamGiaService.getAll();
        if(keyword !=null){
            giamGiaList     = this.giamGiaService.findMaGiamGia(keyword);
        }
        int totalItems = giamGiaList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("nv",nhanVienRepo.findAll());
        model.addAttribute("listGiamGia",giamGiaList);
        model.addAttribute("gg",new GiamGia());
        return "admin/giamgia";

    }
    @RequestMapping("/giam-gia/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<GiamGia> giamGiaList = giamGiaService.findMaGiamGia(keyword);
        model.addAttribute("nv",nhanVienRepo.findAll());
        model.addAttribute("gg",giamGiaList);
        return "admin/giamgia";
    }



}
