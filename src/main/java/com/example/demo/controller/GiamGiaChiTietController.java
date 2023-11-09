package com.example.demo.controller;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.GiamGiaChiTiet;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.GiamGiaChiTietRepository;
import com.example.demo.repository.GiamGiaRepo;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.GiamGiaChiTietService;
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
public class GiamGiaChiTietController {
    @Autowired
    private GiamGiaChiTietService giamGiaChiTietService;
    @Autowired
    private GiamGiaRepo giamGiaRepo;
    @Autowired
    private SanPhamRepo sanPhamRepo;

    @RequestMapping("/giam-gia-chi-tiet")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String getAll(Model model,
                         @Param("keyword") String keyword) {

        List<GiamGiaChiTiet> giamGiaChiTietList = giamGiaChiTietService.getAll();
        model.addAttribute("gg",giamGiaRepo.findAll());
        model.addAttribute("sp",sanPhamRepo.findAll());
        model.addAttribute("listGiamGiaChiTiet",giamGiaChiTietList);
        model.addAttribute("ggct",new GiamGiaChiTiet());
        return "redirect:/giam-gia-chi-tiet/page";
    }
    @RequestMapping(value = "/giam-gia-chi-tiet-add",method = RequestMethod.POST)
    public String addGiamGiaChiTiet(@Valid @ModelAttribute("ggct") GiamGiaChiTiet giamGiaChiTiet,
                             BindingResult result,
                             Model model){
        Respon<GiamGiaChiTiet> respon = giamGiaChiTietService.add(giamGiaChiTiet);
        List<GiamGiaChiTiet> giamGiaChiTietList = giamGiaChiTietService.getAll();
        model.addAttribute("gg",giamGiaRepo.findAll());
        model.addAttribute("sp",sanPhamRepo.findAll());
        model.addAttribute("listGiamGiaChiTiet",giamGiaChiTietList);
        model.addAttribute("ggct",new GiamGiaChiTiet());
        model.addAttribute("repon",respon);
        return "admin/giamgiachitiet";
    }
    @RequestMapping("/giam-gia-chi-tiet/delete/{giamGiaChiTietID}")
    public String delete(@PathVariable("giamGiaChiTietID") Integer giamGiaChiTietID){
       giamGiaChiTietService.delete(giamGiaChiTietID);
        return "redirect:/giam-gia-chi-tiet/page";
    }
    @RequestMapping("/giam-gia-chi-tiet-view-update/{giamGiaChiTietID}")
    public String viewUpdate(@PathVariable("giamGiaChiTietID") Integer giamGiaChiTietID
            ,Model model){
        GiamGiaChiTiet giamGiaChiTiet = giamGiaChiTietService.detail(giamGiaChiTietID);
        List<GiamGiaChiTiet> giamGiaChiTietList = giamGiaChiTietService.getAll();
        model.addAttribute("gg",giamGiaRepo.findAll());
        model.addAttribute("sp",sanPhamRepo.findAll());
        model.addAttribute("listGiamGiaChiTiet",giamGiaChiTietList);
        model.addAttribute("ggct",giamGiaChiTiet);
        return "admin/giamgiachitiet-update";
    }
    @RequestMapping(value = "/giam-gia-chi-tiet/update/{giamGiaChiTietID}",method = RequestMethod.POST)
    public String update(@PathVariable("giamGiaChiTietID") Integer giamGiaChiTietID
            ,GiamGiaChiTiet giamGiaChiTiet,Model model){

        Respon<GiamGiaChiTiet> respon = giamGiaChiTietService.update(giamGiaChiTietID,giamGiaChiTiet);
        List<GiamGiaChiTiet> giamGiaChiTietList = giamGiaChiTietService.getAll();
        model.addAttribute("gg",giamGiaRepo.findAll());
        model.addAttribute("sp",sanPhamRepo.findAll());
        model.addAttribute("listGiamGiaChiTiet",giamGiaChiTietList);
        model.addAttribute("ggct",new GiamGiaChiTiet());
        model.addAttribute("repon",respon);
        return "redirect:/giam-gia-chi-tiet/page";
    }
    @RequestMapping("/giam-gia-chi-tiet/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<GiamGiaChiTiet> page1 = giamGiaChiTietService.getPage(page,size);
        List<GiamGiaChiTiet> giamGiaChiTietList =page1.getContent();
        List<GiamGiaChiTiet> giamGiaChiTietList1 = giamGiaChiTietService.getAll();
        if(keyword !=null){
            giamGiaChiTietList     = this.giamGiaChiTietService.findTenSanPham(keyword);
        }
        int totalItems = giamGiaChiTietList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("gg",giamGiaRepo.findAll());
        model.addAttribute("sp",sanPhamRepo.findAll());
        model.addAttribute("listGiamGiaChiTiet",giamGiaChiTietList);
        model.addAttribute("ggct",new GiamGiaChiTiet());
        return "admin/giamgiachitiet";

    }
    @RequestMapping("/giam-gia-chi-tiet/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<GiamGiaChiTiet> giamGiaChiTietList = giamGiaChiTietService.findTenSanPham(keyword);
        model.addAttribute("gg",giamGiaRepo.findAll());
        model.addAttribute("sp",sanPhamRepo.findAll());
        model.addAttribute("ggct",giamGiaChiTietList);
        return "admin/giamgiachitiet";
    }

}
