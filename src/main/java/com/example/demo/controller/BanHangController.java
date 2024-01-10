package com.example.demo.controller;

import com.example.demo.DTO.RequestBanHang;
import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.BanHangService;
import com.example.demo.service.SanPhamService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
  public String insertsp(@PathVariable("sanPhamID")UUID sanpham,@PathVariable("donhangid")UUID donhang,Model model){
    List<DonHangChiTiet>list=banHangService.getAll(donhang);
    banHangService.insertsp(sanpham,donhang);
    model.addAttribute("listDonHang",list);
    return "redirect:/ban-hang/hienthi?donhangid="+donhang;
  }
  @GetMapping("/ban-hang/hienthi")
  public String hienthi(@RequestParam("donhangid") UUID id, Model model){
    List<DonHangChiTiet>list=banHangService.getAll(id);
    model.addAttribute("listDonHang",list);
    return "shop/ban-hang1";
  }
  @PostMapping("/ban-hang/mua")
  public String mua(@RequestParam("donHangID[]") List<Integer> donhang,@RequestParam("tongtien")float tong,Model model){
    List<DonHangChiTiet> donHangChiTiet=banHangService.banhang(donhang,tong);
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
  @GetMapping("/ban-hang/timkiem")
  @ResponseBody
  public String timkiem(@RequestParam(name = "ten", required = false) String ten, Model model) {
    List<SanPham> list = banHangService.findbyten(ten);
    model.addAttribute("listSanPham", list);
    return "fragments/modal-content"; // Trả về trang HTML chứa danh sách sản phẩm (sanpham.html)
  }
}

