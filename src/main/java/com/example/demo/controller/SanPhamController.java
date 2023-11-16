package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.*;
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
public class SanPhamController {
@Autowired
    SanPhamService sanPhamService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    SizeService sizeService;
    @Autowired
    ChatLieuService chatLieuService;
    @Autowired
    ThuongHieuService thuongHieuService;
    @GetMapping("/san-pham")
    private String getAll(Model model){
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham", sanPhamList);
        model.addAttribute("sp",new SanPham());
        return "sanpham/sanpham";
    }
    @RequestMapping(value = "/san-pham-add", method = RequestMethod.POST)
    public String addSanPham(@RequestParam("hinhAnhURL") MultipartFile file,
                             @Valid @ModelAttribute("sp") SanPham sanPham,
                             BindingResult result, Model model) {
        
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                sanPham.setHinhAnhURL(file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        Respon<SanPham> respon = sanPhamService.add(sanPham);
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham", sanPhamList);
        model.addAttribute("sp", new SanPham());
        model.addAttribute("repon", respon);
        return "sanpham/sanpham";
    }
    @RequestMapping("/san-pham/delete/{sanPhamID}")
    public String delete(@PathVariable("sanPhamID")UUID sanPhamID){
        sanPhamService.delete(sanPhamID);
        return "redirect:/san-pham/page";
    }
    @RequestMapping("/san-pham-view-update/{sanPhamID}")
    public String voidUpdate(@PathVariable("sanPhamID")UUID sanPhamID,Model model){
        SanPham sanPham=sanPhamService.detail(sanPhamID);
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        List<SanPham> sanPhamList=sanPhamService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("sp",sanPham);
        return "sanpham/sanpham-update";
    }
    @RequestMapping(value = "/san-pham/update/{sanPhamID}", method = RequestMethod.POST)
    public String update(@PathVariable("sanPhamID") UUID sanPhamID, SanPham sanPham,Model model) {
       Respon<SanPham>respon= sanPhamService.update(sanPhamID, sanPham);
       model.addAttribute("repon",respon);
        return "redirect:/san-pham/page";
    }
    @RequestMapping("/san-pham/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword) {
        Page<SanPham> page1 = sanPhamService.getPage(page, size);
        List<SanPham> sanPhamList= page1.getContent();
        List<SanPham> nhapKhoList1 = sanPhamService.getAll();
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();

        int totalItems = nhapKhoList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listSanPham", sanPhamList);
        model.addAttribute("sp", new SanPham());
        return "sanpham/sanpham";

    }
//    @GetMapping("/san-pham-gio/{sanPhamID}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String sanphamgio(@PathVariable("sanPhamID")UUID sanPhamID,Model model){
//       SanPham sanPham=sanPhamService.themgio(sanPhamID);
//        model.addAttribute("gh",sanPham);
//        return "shop/gio-hangdemo";
//    }

}
