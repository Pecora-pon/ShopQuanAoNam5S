package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.*;
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
public class XuatKhoController {
    @Autowired
    XuatKhoService xuatKhoService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    SizeService sizeService;
    @Autowired
    ChatLieuService chatLieuService;
    @Autowired
    NhaCungCapService nhaCungCapService;
    @Autowired
    SanPhamService sanPhamService;
    @RequestMapping("/xuat-kho")
    public String getAll(Model model) {
        List<XuatKho> xuatKhoList = xuatKhoService.getAll();
        List<MauSac> mauSacList=mauSacService.getAll();
        List<ChatLieu>chatLieuList=chatLieuService.getAll();
        List<Size>sizeList=sizeService.getAll();
        List<SanPham>sanPhamList=sanPhamService.getAll();
        List<NhaCungCap>nhaCungCapList=nhaCungCapService.getAll();
        model.addAttribute("listXuatKho",xuatKhoList);
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("listChatLieu",chatLieuList);
        model.addAttribute("listSize",sizeList);
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("listNhaCungCap",nhaCungCapList);
        model.addAttribute("xk",new XuatKho());
        return "sanpham/xuatkho";
    }
    @RequestMapping(value = "/xuat-kho-add",method = RequestMethod.POST)
    public String addNhapKho(@Valid @ModelAttribute("xk") XuatKho xuatKho, BindingResult result, Model model){
        Respon<XuatKho> respon=  xuatKhoService.add(xuatKho);
        List<XuatKho> xuatKhoList = xuatKhoService.getAll();
        model.addAttribute("listXuatKho",xuatKhoList);
        model.addAttribute("repon",respon);
        return "sanpham/xuatkho";
    }
    @RequestMapping("/xuat-kho/delete/{xuatKhoID}")
    public String delete(@PathVariable("xuatKhoID") Integer xuatKhoID){
        xuatKhoService.delete(xuatKhoID);
        return "redirect:/xuat-kho/page";
    }
    @RequestMapping("/xuat-kho-view-update/{xuatKhoID}")
    public String viewUpdate(@PathVariable("xuatKhoID") Integer xuatKhoID,Model model){
        XuatKho xuatKho = xuatKhoService.detail(xuatKhoID);
        List<XuatKho> xuatKhoList = xuatKhoService.getAll();
        List<MauSac> mauSacList=mauSacService.getAll();
        List<ChatLieu>chatLieuList=chatLieuService.getAll();
        List<Size>sizeList=sizeService.getAll();
        List<SanPham>sanPhamList=sanPhamService.getAll();
        List<NhaCungCap>nhaCungCapList=nhaCungCapService.getAll();
        model.addAttribute("listXuatKho",xuatKhoList);
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("listChatLieu",chatLieuList);
        model.addAttribute("listSize",sizeList);
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("listNhaCungCap",nhaCungCapList);
        model.addAttribute("xk",xuatKho);
        return "sanpham/xuatkho-update";
    }
    @RequestMapping(value = "/xuat-kho/update/{xuatKhoID}",method = RequestMethod.POST)
    public String update(@PathVariable("nhapKhoID") Integer xuatKhoID,XuatKho xuatKho,Model model){
       Respon<XuatKho> respon= xuatKhoService.update(xuatKhoID,xuatKho);
       model.addAttribute("repon",respon);
        return "redirect:/xuat-kho/page";
    }
    @RequestMapping("/xuat-kho/searchNhaCC")
    public String searchNhaCC(Model model,
                         @RequestParam("nhaCungCap") Integer nhaCC){
        List<XuatKho> xuatKhoList = xuatKhoService.findNhaCC(nhaCC);
        model.addAttribute("xk",xuatKhoList);
        return "sanpham/xuatkho";
    }
    @RequestMapping("/xuat-kho/searchSize/{size}")
    public String searchSize(Model model,
                         @PathVariable("size") Integer size){
        List<XuatKho> xuatKhoList = xuatKhoService.findSize(size);
        model.addAttribute("xk",xuatKhoList);
        return "sanpham/xuatkho";
    }
    @RequestMapping("/xuat-kho/searchChatLieu/{chatLieu}")
    public String searchChatLieu(Model model,
                             @PathVariable("chatLieu") Integer chatLieu){
        List<XuatKho> xuatKhoList = xuatKhoService.findChatLieu(chatLieu);
        model.addAttribute("xk",xuatKhoList);
        return "sanpham/xuatkho";
    }
    @RequestMapping("/xuat-kho/searchMauSac/{mauSac}")
    public String searchmausac(Model model,
                             @PathVariable("mauSac") Integer mauSac){
        List<XuatKho> xuatKhoList = xuatKhoService.findMauSac(mauSac);
        model.addAttribute("xk",xuatKhoList);
        return "sanpham/xuatkho";
    }
    @RequestMapping("/xuat-kho/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<XuatKho> page1 = xuatKhoService.getPage(page,size);
        List<XuatKho> xuatKhoList =page1.getContent();
        List<XuatKho> xuatKhoList1 = xuatKhoService.getAll();
        List<MauSac> mauSacList=mauSacService.getAll();
        List<ChatLieu>chatLieuList=chatLieuService.getAll();
        List<Size>sizeList=sizeService.getAll();
        int totalItems = xuatKhoList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("listXuatKho",xuatKhoList);
        model.addAttribute("listMauSac",mauSacList);
        model.addAttribute("listChatLieu",chatLieuList);
        model.addAttribute("listSize",sizeList);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listXuatKho",xuatKhoList);
        model.addAttribute("xk",new XuatKho());
        return "sanpham/xuatkho";

    }
}
