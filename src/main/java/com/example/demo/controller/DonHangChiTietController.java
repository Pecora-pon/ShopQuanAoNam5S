package com.example.demo.controller;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.GiamGia;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.ThongTinVanChuyen;
import com.example.demo.service.DonHangChiTietService;
import com.example.demo.service.DonHangService;
import com.example.demo.service.GiamGiaService;
import com.example.demo.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller

public class DonHangChiTietController {

    @Autowired
    private DonHangChiTietService donHangChiTietService;

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private GiamGiaService giamGiaService;

    @GetMapping("/hien-thi")
    public String hienthi(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet, Model model){
        List<DonHangChiTiet> list = donHangChiTietService.getAll();
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();

        model.addAttribute("list",list);
        model.addAttribute("listDH",listDH);
        model.addAttribute("listSP",listSP);

        return "admin/don-hang-chi-tiet/index";
    }

    @GetMapping("/delete/{donHangChiTietID}")
    public String delete(@PathVariable("donHangChiTietID") Integer donHangChiTietID){
        donHangChiTietService.delete(donHangChiTietID);
        return "redirect:/don-hang-chi-tiet";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("dhct")DonHangChiTiet donHangChiTiet){
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        donHangChiTietService.add(donHangChiTiet);
        return "redirect:/don-hang-chi-tiet";
    }

    @GetMapping("/{donHangChiTietID}")
    public String viewupdate(@PathVariable("donHangChiTietID") Integer donHangChiTietID,Model model){
        DonHangChiTiet dhct = donHangChiTietService.detail(donHangChiTietID);
        List<DonHangChiTiet> list = donHangChiTietService.getAll();
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        model.addAttribute("list",list);
        model.addAttribute("listDH",listDH);
        model.addAttribute("listSP",listSP);
        model.addAttribute("listGG",listGG);
        model.addAttribute("dhct",dhct);
        return "admin/don-hang-chi-tiet/view-update";
    }

    @GetMapping("/don-hang-chi-tiet/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
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
        return "admin/don-hang-chi-tiet";

    }

    @PostMapping("/update/{donHangChiTietID}")
    public String update(@Valid @ModelAttribute("dhct")DonHangChiTiet donHangChiTiet){
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        donHangChiTietService.add(donHangChiTiet);
        return "redirect:/don-hang-chi-tiet";
    }
   @GetMapping("/chuyentt/{donHangID}")
    public String chuyentt(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyentrangthai(id);
        return "redirect:/hien-thi";
   }
   @GetMapping("/long")
    public String vt(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet,Model model){
       List<DonHangChiTiet> list = donHangChiTietService.getAlll();
       model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/vanchuyen";
   }
//   @GetMapping("/hien-thi1")
//    public String vtt(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet,Model model){
//       List<DonHangChiTiet> list = donHangChiTietService.getAlll();
//       model.addAttribute("list",list);
//       return "admin/don-hang-chi-tiet/vanchuyen";
//   }
   @GetMapping("/chuyenvc/{donHangID}")
    public String chuyent(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensangxn(id);
        return "redirect:/long";
   }

   @GetMapping("/longg")
    public String vttt(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model){
        List<DonHangChiTiet> list=donHangChiTietService.getTC();
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/choxacnhan";
   }
    @GetMapping("/longgg")
    public String vtttt(@ModelAttribute("dhct")DonHangChiTiet donHangChiTiet,Model model){
        List<DonHangChiTiet> list=donHangChiTietService.gethuy();
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/thanhcong";
    }
    @GetMapping("/chuyentc/{donHangID}")
    public String chuyentc(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensangtc(id);
        return "redirect:/longg";
    }
    @GetMapping("/huyd/{donHangID}")
    public String vv(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/hien-thi";
    }
 @GetMapping("/huydd/{donHangID}")
 public String vvv(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/long";
 }
   @GetMapping("/huy/{donHangID}")
    public String v(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/longg";
   }
   @GetMapping("/xemhuy")
    public String huy(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.gethuyttt();
        model.addAttribute("list",list);
                return "admin/don-hang-chi-tiet/dahuy";
   }

//   @GetMapping("/detail/{donHang}")
//    public String detail(@PathVariable("donHang")UUID donHang,Model model){
//        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
//        model.addAttribute("list",list);
//        return "admin/don-hang-chi-tiet/chitiet";
//   }
@GetMapping("/timkiemten1")
public String detail1(@RequestParam("ten")String ten, Model model){
    List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
    model.addAttribute("list",list);
    return "admin/don-hang-chi-tiet/index";
}
    @GetMapping("/timkiemngay1")
    public String timKiemTheoNgay(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/index";
    }
    @GetMapping("/timkiemtongtien1")
    public String timKiemtongtien(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/index";
    }
    @GetMapping("/timkiemtendh1")
    public String detaildh(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/dahuy";
    }
    @GetMapping("/timkiemngaydh1")
    public String timKiemTheoNgaydh(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/dahuy";
    }
    @GetMapping("/timkiemtongtiendh1")
    public String timKiemtongtiendh(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/dahuy";
    }
    @GetMapping("/timkiemtenvc1")
    public String detailvc(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/vanchuyen";
    }
    @GetMapping("/timkiemngayvc1")
    public String timKiemTheoNgayvc(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/vanchuyen";
    }
    @GetMapping("/timkiemtongtienvc1")
    public String timKiemtongtienvc(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/vanchuyen";
    }
    @GetMapping("/timkiemtenxn1")
    public String detailxn(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/choxacnhan";
    }
    @GetMapping("/timkiemngayxn1")
    public String timKiemTheoNgayxn(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/choxacnhan";
    }
    @GetMapping("/timkiemtongtienxn1")
    public String timKiemtongtienxn(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/choxacnhan";
    }
    @GetMapping("/timkiemtentc1")
    public String detailtc(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/thanhcong";
    }
    @GetMapping("/timkiemngaytc1")
    public String timKiemTheoNgaytc(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/thanhcong";
    }
    @GetMapping("/timkiemtongtientc1")
    public String timKiemtongtientc(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/thanhcong";
    }
}
