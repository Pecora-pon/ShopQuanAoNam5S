package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.*;
import com.example.demo.service.impl.FileUploaderNKServiceImpl;
import com.example.demo.service.impl.FileUploaderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class NhapKhoController {
    @Autowired
    NhapKhoService nhapKhoService;
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
    @Autowired
    FileUploaderService fileUploaderService;

    @GetMapping("/nhap-kho")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAll(Model model) {
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll();
        List<Size> sizeList = sizeService.getAll();
        List<SanPham> sanPhamList=sanPhamService.getAll();
        List<NhapKho> nhapKhoList = nhapKhoService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listNhaCungCap", nhaCungCapList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("listNhapKho", nhapKhoList);
        model.addAttribute("nk", new NhapKho());
        return "sanpham/nhapkho";
    }

    @RequestMapping(value = "/nhap-kho-add", method = RequestMethod.POST)
    public String addNhapKho(@Valid @ModelAttribute("nk") NhapKho nhapKho, BindingResult result, Model model) {
        Respon<NhapKho>respon=nhapKhoService.add(nhapKho);
        List<NhapKho> nhapKhoList = nhapKhoService.getAll();
        model.addAttribute("listNhapKho", nhapKhoList);
        model.addAttribute("repon",respon);
        return "sanpham/nhapkho";
    }

    @RequestMapping("/nhap-kho/delete/{nhapKhoID}")
    public String delete(@PathVariable("nhapKhoID") Integer nhapKhoID) {
        nhapKhoService.delete(nhapKhoID);
        return "redirect:/nhap-kho/page";
    }

    @RequestMapping("/nhap-kho-view-update/{nhapKhoID}")
    public String viewUpdate(@PathVariable("nhapKhoID") Integer nhapKhoID, Model model) {
        NhapKho nhapKho = nhapKhoService.detail(nhapKhoID);
        List<NhapKho> nhapKhoList = nhapKhoService.getAll();
        List<MauSac> mauSacList = mauSacService.getAll();
        List<SanPham> sanPhamList=sanPhamService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll();
        List<Size> sizeList = sizeService.getAll();
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listNhaCungCap", nhaCungCapList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listNhapKho", nhapKhoList);
        model.addAttribute("nk", nhapKho);
        return "sanpham/nhapkho-update";
    }

    @RequestMapping(value = "/nhap-kho/update/{nhapKhoID}", method = RequestMethod.POST)
    public String update(@PathVariable("nhapKhoID") Integer nhapKhoID, NhapKho nhapKho,Model model) {
       Respon<NhapKho>respon= nhapKhoService.update(nhapKhoID, nhapKho);
        List<NhapKho> nhapKhoList = nhapKhoService.getAll();
        List<MauSac> mauSacList = mauSacService.getAll();
        List<SanPham> sanPhamList=sanPhamService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll();
        List<Size> sizeList = sizeService.getAll();
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listNhaCungCap", nhaCungCapList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listNhapKho", nhapKhoList);
        model.addAttribute("repon",respon);
        return "redirect:/nhap-kho/page";
    }

    @RequestMapping("/nhap-kho/searchNhaCC/{nhaCungCap}")
    public String searchNhaCC(Model model,
                              @PathVariable("nhaCungCap") Integer nhaCC) {
        List<NhapKho> nhapKhoList = nhapKhoService.findNhaCC(nhaCC);
        model.addAttribute("nk", nhapKhoList);
        return "sanpham/nhapkho";
    }

    @RequestMapping("/nhap-kho/searchSize/{size}")
    public String searchSize(Model model,
                             @PathVariable("size") Integer size) {
        List<NhapKho> nhapKhoList = nhapKhoService.findSize(size);
        model.addAttribute("nk", nhapKhoList);
        return "sanpham/nhapkho";
    }

    @RequestMapping("/nhap-kho/searchChatLieu/{chatLieu}")
    public String searchChatLieu(Model model,
                                 @PathVariable("chatLieu") Integer chatLieu) {
        List<NhapKho> nhapKhoList = nhapKhoService.findChatLieu(chatLieu);
        model.addAttribute("nk", nhapKhoList);
        return "sanpham/nhapkho";
    }

    @RequestMapping("/nhap-kho/searchMauSac/{mauSac}")
    public String searchmausac(Model model,
                               @PathVariable("mauSac") Integer mauSac) {
        List<NhapKho> nhapKhoList = nhapKhoService.findMauSac(mauSac);
        model.addAttribute("nk", nhapKhoList);
        return "sanpham/nhapkho";
    }

    @RequestMapping("/nhap-kho/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword) {
        Page<NhapKho> page1 = nhapKhoService.getPage(page, size);
        List<NhapKho> nhapKhoList = page1.getContent();
        List<NhapKho> nhapKhoList1 = nhapKhoService.getAll();
        List<MauSac> mauSacList = mauSacService.getAll();
        List<SanPham> sanPhamList=sanPhamService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<NhaCungCap> nhaCungCapList = nhaCungCapService.getAll();
        List<Size> sizeList = sizeService.getAll();
        int totalItems = nhapKhoList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listNhaCungCap", nhaCungCapList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listNhapKho", nhapKhoList);
        model.addAttribute("nk", new NhapKho());
        return "sanpham/nhapkho";

    }
//    @PostMapping("/them")
//    public String them(@ModelAttribute("nk") NhapKho nhapKho, Model model){
//        NhapKho nhapKho1=nhapKhoService.themmoi(nhapKho);
//        List<NhapKho> nhapKhoList = nhapKhoService.getAll();
//        model.addAttribute("listNhapKho", nhapKhoList);
//        model.addAttribute("nk",nhapKho1);
//        return "redirect:/nhap-kho";
//
//    }
    @GetMapping("/uploadexelnk")
    public String getupload(@ModelAttribute("nk") SanPham sanPham){
        return "sanpham/uploadexelnk";
    }
    @PostMapping("/uploadexelnk")
    public String uploadexel(@RequestParam("fileLoactionnk") MultipartFile file) {
        try {
            fileUploaderService.uploadFilenk(file);
        } catch (IOException e) {
            // Xử lý IOException nếu cần thiết
            e.printStackTrace();
        }
        return "sanpham/uploadexelnk";
    }
}
