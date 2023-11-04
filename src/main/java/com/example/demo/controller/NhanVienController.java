package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.service.NhanVienService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private NhanVienRepo nhanVienRepo;
    @RequestMapping("/nhan-vien")
    public String getAll(Model model,
                         @Param("keyword") String keyword){

        List<NhanVien> nhanVienList = nhanVienService.getAll();
        model.addAttribute("listNhanVien",nhanVienList);
        model.addAttribute("nv",new NhanVien());
        return "admin/nhanvien";
    }
    @RequestMapping(value = "/nhan-vien-add",method = RequestMethod.POST)
    public String addNhanVien(@Valid @ModelAttribute("nv") NhanVien nhanVien,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            return "admin/nhanvien";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/page";
    }
    @RequestMapping("/nhan-vien/delete/{nhanVienID}")
    public String delete(@PathVariable("nhanVienID") Integer nhanVienID){
        nhanVienService.delete(nhanVienID);
        return "redirect:/nhan-vien/page";
    }
    @RequestMapping("/nhan-vien-view-update/{nhanVienID}")
    public String viewUpdate(@PathVariable("nhanVienID") Integer nhanVienID
                            ,Model model){
        NhanVien nhanVien = nhanVienService.detail(nhanVienID);
        List<NhanVien> nhanVienList = nhanVienService.getAll();
        model.addAttribute("listNhanVien",nhanVienList);
        model.addAttribute("nv",nhanVien);
        return "admin/nhanvien-update";
    }
    @RequestMapping(value = "/nhan-vien/update/{nhanVienID}",method = RequestMethod.POST)
    public String update(@PathVariable("nhanVienID") Integer nhanVienID
                        ,NhanVien nhanVien){
        nhanVienService.update(nhanVienID,nhanVien);
        return "redirect:/nhan-vien/page";
    }
    @RequestMapping("/nhan-vien/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<NhanVien> page1 = nhanVienService.getPage(page,size);
        List<NhanVien> nhanVienList =page1.getContent();
        List<NhanVien> nhanVienList1 = nhanVienService.getAll();
        if(keyword !=null){
            nhanVienList= this.nhanVienService.findTenOrDiaChi(keyword);
        }
        int totalItems = nhanVienList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listNhanVien",nhanVienList);
        model.addAttribute("nv",new NhanVien());
        return "admin/nhanvien";

    }
    @RequestMapping(value = "/nhan-vien/search/{keyword}")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<NhanVien> nhanVienList = nhanVienService.findTenOrDiaChi(keyword);
        model.addAttribute("listNhanVien",nhanVienList);
        return "admin/nhanvien";
    }




}
