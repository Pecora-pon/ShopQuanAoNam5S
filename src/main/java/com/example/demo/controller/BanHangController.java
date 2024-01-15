package com.example.demo.controller;

import com.example.demo.DTO.RequestBanHang;
import com.example.demo.entity.*;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.BanHangService;
import com.example.demo.service.GiamGiaService;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.SanPhamService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BanHangController {
  @Autowired
  BanHangService banHangService;
  @Autowired
  SanPhamService sanPhamService;
  @Autowired
  SanPhamRepo sanPhamRepo;
  @Autowired
  KhachHangService khachHangService;
  @Autowired
  GiamGiaService giamGiaService;
  @PostMapping("/ban-hang/insert")
  public String insert(@Valid @ModelAttribute("dh")DonHang donHang){
    banHangService.insertdh(donHang);
    return "redirect:/ban-hang/getAll";
  }
  @GetMapping("/ban-hang/getAll")
  public String getAll(Model model){
    List<DonHang> list=banHangService.getAlll();
    List<SanPham>list1=sanPhamService.getAll();
    model.addAttribute("listBanHang",list);
    model.addAttribute("listSanPham",list1);
    return "shop/ban-hang";
  }
  @GetMapping("/ban-hang/detail/{sanPhamID}")
  public String detail(@PathVariable("sanPhamID") UUID id, Model model){
    SanPham sp=sanPhamService.detail(id);
    model.addAttribute("sp",sp);
    return "shop/ban-hang1";
  }
  @GetMapping("/ban-hang/insertsp/{sanPhamID}/{donhangid}")
  public String insertsp(@PathVariable("sanPhamID")UUID sanpham,@PathVariable("donhangid")UUID donhang,@RequestParam("soLuong")int soLuong, Model model){
    List<DonHangChiTiet>list=banHangService.getAll(donhang);
    banHangService.insertsp(sanpham,donhang,soLuong);
    model.addAttribute("listDonHang",list);
    return "redirect:/ban-hang/hienthi?donhangid="+donhang;
  }
  @GetMapping("/ban-hang/hienthi")
  public String hienthi(@RequestParam("donhangid") UUID id, Model model){
    List<DonHangChiTiet>list=banHangService.getAll(id);
    List<KhachHang>list1=khachHangService.getAll();
    List<GiamGia>list2=giamGiaService.getAll();
    model.addAttribute("listGiamGia",list2);
    model.addAttribute("listKhachHang",list1);
    model.addAttribute("listDonHang",list);
    return "shop/ban-hang1";
  }
  @PostMapping("/ban-hang/mua")
  public String mua(@RequestParam("donHangID[]") List<Integer> donhang,@RequestParam("tongtien1")float tong,@RequestParam(name = "khachHang", defaultValue = "-1")Integer khachhang, Model model){
    List<DonHangChiTiet> donHangChiTiet;
    if(khachhang != -1) {
       donHangChiTiet = banHangService.banhang(donhang, tong, khachhang);
    }else {
      donHangChiTiet = banHangService.banhang1(donhang, tong);
    }
    model.addAttribute("donHangChiTietList",donHangChiTiet);
    return "shop/thanhcong";
  }
 @GetMapping("/ban-hang/delete/{donhangct}/{donhangid}")
  public String delete(@PathVariable("donhangct")int id,@PathVariable("donhangid")UUID donhang, Model model){
    banHangService.delete(id);
  return "redirect:/ban-hang/hienthi?donhangid="+donhang;
 }
 @GetMapping("/ban-hang/delete1/{donhangid}")
  public String delete1(@PathVariable("donhangid")UUID id){
    banHangService.delete1(id);
    return "redirect:/ban-hang/getAll";
 }
  @GetMapping("/ban-hang/timkiemten1")
  public ResponseEntity<List<SanPham>> timKiemTheoTen(@RequestParam(name = "ten") String ten, Model model) {
    List<SanPham> searchResults = banHangService.findbyten(ten);

    model.addAttribute("listSanPham",searchResults);
    return ResponseEntity.ok(searchResults);
  }
  @RequestMapping(value = "/ban-hang/page", method = RequestMethod.GET)
  public String page(@RequestParam(defaultValue = "1") int page,
                     @RequestParam(defaultValue = "6") int size,
                     Model model,
                     @Param("keyword") String keyword,
                     @Param("getimage/hinhAnhURL")String hinhAnhURL) {
    Page<SanPham> page1 = sanPhamService.getPage(page - 1, size);
    List<SanPham> sanPhamList= page1.getContent();
    List<SanPham> nhapKhoList1 = sanPhamService.getAll();
    List<DonHang> list=banHangService.getAlll();
    List<SanPham>list1=sanPhamService.getAll();


    int totalItems = nhapKhoList1.size();
    int itemsPerPage = size;
    int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
    int currentPage = page;
    model.addAttribute("listBanHang",list);
    model.addAttribute("listSanPham",list1);
    model.addAttribute("currentPage", currentPage);
    model.addAttribute("totalPages", totalPages);
    model.addAttribute("itemsPerPage", itemsPerPage);
    model.addAttribute("totalItems", totalItems);
    model.addAttribute("listSanPham", sanPhamList);
    model.addAttribute("sp", new SanPham());
    return "shop/ban-hang";
  }
}

