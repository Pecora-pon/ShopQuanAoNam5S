package com.example.demo.controller;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.service.DonHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
public class KhachHangXemDonHang {
    @Autowired
    private DonHangChiTietService donHangChiTietService;
    @GetMapping("/choxacnhan")
    public String choxacnhan(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet, Model model, Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet> list=donHangChiTietService.findkhachHang5(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/choxacnhan";
    }
    @GetMapping("/dangxem")
    public String dangxem(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet, Model model, Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet> list=donHangChiTietService.findkhachHang(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/dadat";
    }
    @GetMapping("/vanchuyen")
    public String vanchuyen(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet, Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang1(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/vanchuyen";
    }
    @GetMapping("/xacnhan")
    public String xacnhan(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang2(username);
        model.addAttribute("list",list);
                return "admin/khach-hang-xem-don/xacnhan";
    }
    @GetMapping("/thanhcong")
    public String thanhcong(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang3(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/thanhcong";
    }
    @GetMapping("/dahuy")
    public String dahuy(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model,Authentication authentication){
        String username=authentication.getName();
        List<DonHangChiTiet>list=donHangChiTietService.findkhachHang4(username);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/dahuy";
    }
//    @GetMapping("/huydx/{donHangID}")
//    public String huys(@PathVariable("donHangID")UUID id){
//        donHangChiTietService.chuyensanghuy(id);
//        return "redirect:/dangxem";
//    }
    @GetMapping("/huycho/{donHangID}")
    public String huycho(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/choxacnhan";
    }
    @GetMapping("/huyt/{donHangID}")
    public String huyy(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/vanchuyen";
    }
    @GetMapping("/huytt/{donHangID}")
    public String huyyy(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/xacnhan";
    }
    @GetMapping("/huydacho/{donHangID}")
    public String huyyyy(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensangchohuy(id);
        return "redirect:/dangxem";
    }
   @GetMapping("/khxacnhan/{donHangID}")
    public String xn(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensangtc(id);
        return "redirect:/xacnhan";
   }
    @GetMapping("/detail/{donHang}")
    public String detail(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/chitiet";
    }
    @GetMapping("/detail1/{donHang}")
    public String detail1(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/chitiet";
    }
    @GetMapping("/detail2/{donHang}")
    public String detail2(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/chitiet";
    }
    @GetMapping("/detail3/{donHang}")
    public String detail3(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/chitiet";
    }
    @GetMapping("/detail4/{donHang}")
    public String detail4(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/chitiet";
    }
    @GetMapping("/detail5/{donHang}")
    public String detail5(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/review-nguoi-dung/index";
    }
    @GetMapping("/timkiemten")
    public String detail1(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/dadat";
    }
    @GetMapping("/timkiemngay")
    public String timKiemTheoNgay(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/dadat";
    }
    @GetMapping("/timkiemtongtien")
    public String timKiemtongtien(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/dadat";
    }
    @GetMapping("/timkiemtendh")
    public String detaildh(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/dahuy";
    }
    @GetMapping("/timkiemngaydh")
    public String timKiemTheoNgaydh(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/dahuy";
    }
    @GetMapping("/timkiemtongtiendh")
    public String timKiemtongtiendh(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/dahuy";
    }
    @GetMapping("/timkiemtenvc")
    public String detailvc(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/vanchuyen";
    }
    @GetMapping("/timkiemngayvc")
    public String timKiemTheoNgayvc(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/vanchuyen";
    }
    @GetMapping("/timkiemtongtienvc")
    public String timKiemtongtienvc(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/vanchuyen";
    }
    @GetMapping("/timkiemtenxn")
    public String detailxn(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/xacnhan";
    }
    @GetMapping("/timkiemngayxn")
    public String timKiemTheoNgayxn(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/xacnhan";
    }
    @GetMapping("/timkiemtongtienxn")
    public String timKiemtongtienxn(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/xacnhan";
    }
    @GetMapping("/timkiemtentc")
    public String detailtc(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/thanhcong";
    }
    @GetMapping("/timkiemngaytc")
    public String timKiemTheoNgaytc(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/thanhcong";
    }
    @GetMapping("/timkiemtongtientc")
    public String timKiemtongtientc(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/thanhcong";
    }
    @GetMapping("/timkiemtencxn")
    public String detailcxn(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/khach-hang-xem-don/choxacnhan";
    }
    @GetMapping("/timkiemngaycxn")
    public String timKiemTheoNgaytcxn(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/choxacnhan";
    }
    @GetMapping("/timkiemtongtiencxn")
    public String timKiemtongtiencxn(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/khach-hang-xem-don/choxacnhan";
    }
    @GetMapping("/khach-hang-xem/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "6") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DonHangChiTiet> page1 = donHangChiTietService.getPage(page,size);
        List<DonHangChiTiet> list =page1.getContent();
        List<DonHangChiTiet> list1 = donHangChiTietService.getAll();
        if(keyword !=null){
            list1     = this.donHangChiTietService.findTenKhachHang(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("list",list);
        model.addAttribute("dh",new DonHang());
        return "admin/khach-hang-xem-don/dadat";

    }
    @GetMapping("/khach-hang-xem/page1")
    public String page1(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "6") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DonHangChiTiet> page1 = donHangChiTietService.getPage1(page,size);
        List<DonHangChiTiet> list =page1.getContent();
        List<DonHangChiTiet> list1 = donHangChiTietService.getAll();
        if(keyword !=null){
            list1     = this.donHangChiTietService.findTenKhachHang(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("list",list);
        model.addAttribute("dh",new DonHang());
        return "admin/khach-hang-xem-don/vanchuyen";

    }
    @GetMapping("/khach-hang-xem/page2")
    public String page2(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "6") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DonHangChiTiet> page1 = donHangChiTietService.getPage2(page,size);
        List<DonHangChiTiet> list =page1.getContent();
        List<DonHangChiTiet> list1 = donHangChiTietService.getAll();
        if(keyword !=null){
            list1     = this.donHangChiTietService.findTenKhachHang(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("list",list);
        model.addAttribute("dh",new DonHang());
        return "admin/khach-hang-xem-don/xacnhan";

    }
    @GetMapping("/khach-hang-xem/page3")
    public String page3(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "6") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DonHangChiTiet> page1 = donHangChiTietService.getPage3(page,size);
        List<DonHangChiTiet> list =page1.getContent();
        List<DonHangChiTiet> list1 = donHangChiTietService.getAll();
        if(keyword !=null){
            list1     = this.donHangChiTietService.findTenKhachHang(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("list",list);
        model.addAttribute("dh",new DonHang());
        return "admin/khach-hang-xem-don/dadat";

    }
    @GetMapping("/khach-hang-xem/page4")
    public String page4(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "6") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DonHangChiTiet> page1 = donHangChiTietService.getPage4(page,size);
        List<DonHangChiTiet> list =page1.getContent();
        List<DonHangChiTiet> list1 = donHangChiTietService.getAll();
        if(keyword !=null){
            list1     = this.donHangChiTietService.findTenKhachHang(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("list",list);
        model.addAttribute("dh",new DonHang());
        return "admin/khach-hang-xem-don/dadat";

    }
    @GetMapping("/khach-hang-xem/page5")
    public String page5(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "6") int size,
                        Model model,
                        @Param("keyword") String keyword){
        Page<DonHangChiTiet> page1 = donHangChiTietService.getPage5(page,size);
        List<DonHangChiTiet> list =page1.getContent();
        List<DonHangChiTiet> list1 = donHangChiTietService.getAll();
        if(keyword !=null){
            list1     = this.donHangChiTietService.findTenKhachHang(keyword);
        }
        int totalItems = list1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("list",list);
        model.addAttribute("dh",new DonHang());
        return "admin/khach-hang-xem-don/dadat";

    }
}

