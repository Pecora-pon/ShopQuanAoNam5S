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
import org.springframework.http.ResponseEntity;
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
//
//    @GetMapping("/don-hangct/delete/{donHang}")
//    public ResponseEntity<Double> delete1(@PathVariable("donHang") int sanpham){
//       double dh= donHangChiTietService.delete1(sanpham);
//        return ResponseEntity.ok(dh);
//    }
//   @GetMapping("/get-price/{sanPhamID}")
//   public ResponseEntity<Double> get(@PathVariable UUID id){
//        try{
//            SanPham sanPham=sanPhamService.detail(id);
//            if(sanPham !=null){
//                double price=sanPham.getGiaSanPham();
//                return ResponseEntity.ok(price);
//            }else {
//                return ResponseEntity.notFound().build();
//            }
//        }catch (Exception e){
//            return ResponseEntity.badRequest().build();
//        }
//   }
    @GetMapping("/don-hang")
    public String hienthi(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet, Model model){
        List<DonHangChiTiet> list = donHangChiTietService.getAllll();
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();

        model.addAttribute("list",list);
        model.addAttribute("listDH",listDH);
        model.addAttribute("listSP",listSP);

        return "admin/don-hang-chi-tiet/xacnhan";
    }
    @GetMapping("/hien-thi2")
    public String hienthi2(@ModelAttribute("dhctt") DonHangChiTiet donHangChiTiet, Model model){
        List<DonHangChiTiet> list = donHangChiTietService.getAlllll();
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();

        model.addAttribute("list",list);
        model.addAttribute("listDH",listDH);
        model.addAttribute("listSP",listSP);

        return "admin/don-hang-chi-tiet/choxacnhanhuy";
    }
    @GetMapping("/hien-thi1")
    public String hienthi1(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet, Model model){
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
        model.addAttribute("dhct",new DonHang());
        return "admin/don-hang-chi-tiet/index";

    }
    @GetMapping("/don-hang-chi-tiet/page1")
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
        model.addAttribute("dhct",new DonHang());
        return "admin/don-hang-chi-tiet/vanchuyen";

    }
    @GetMapping("/don-hang-chi-tiet/page2")
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
        model.addAttribute("dhct",new DonHang());
        return "admin/don-hang-chi-tiet/choxacnhan";

    }
    @GetMapping("/don-hang-chi-tiet/page3")
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
        model.addAttribute("dhct",new DonHang());
        return "admin/don-hang-chi-tiet/thanhcong";

    }
    @GetMapping("/don-hang-chi-tiet/page4")
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
        model.addAttribute("dhct",new DonHang());
        return "admin/don-hang-chi-tiet/dahuy";

    }
    @GetMapping("/don-hang-chi-tiet/page5")
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
        model.addAttribute("dhct",new DonHang());
        return "admin/don-hang-chi-tiet/dahuy";

    }
    @PostMapping("/update/{donHangChiTietID}")
    public String update(@Valid @ModelAttribute("dhct")DonHangChiTiet donHangChiTiet){
        List<DonHang> listDH = donHangService.getAll();
        List<SanPham> listSP = sanPhamService.getAll();
        List<GiamGia> listGG = giamGiaService.getAll();
        donHangChiTietService.add(donHangChiTiet);
        return "redirect:/don-hang-chi-tiet";
    }
    @GetMapping("/chuyenttt/{donHangID}")
    public String chuyenttt(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyentrangthaicho(id);
        return "redirect:/don-hang";
    }
   @GetMapping("/chuyentt/{donHangID}")
    public String chuyentt(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyentrangthai(id);
        return "redirect:/hien-thi1";
   }
   @GetMapping("/long")
    public String vt(@ModelAttribute("dhct") DonHangChiTiet donHangChiTiet,Model model){
       List<DonHangChiTiet> list = donHangChiTietService.getAlll();
       model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/vanchuyen";
   }
    @GetMapping("/chuyentttt/{donHangID}")
    public String chuyentttt(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyentrangthaicho1(id);
        return "redirect:/hien-thi2";
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
   } @GetMapping("/nvxacnhan/{donHangID}")
    public String xn(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensangtc(id);
        return "redirect:/longg";
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
        return "redirect:/don-hang";
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
    @GetMapping("/huycho1/{donHangID}")
    public String vvvv(@PathVariable("donHangID")UUID id){
        donHangChiTietService.chuyensanghuy(id);
        return "redirect:/hien-thi2";
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
    List<DonHangChiTiet> list=donHangChiTietService.findTenSP(ten,0);
    model.addAttribute("list",list);
    return "admin/don-hang-chi-tiet/index";
}
    @GetMapping("/timkiemngay1")
    public String timKiemTheoNgay(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat(ngaydat,0);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/index";
    }
    @GetMapping("/timkiemtongtien1")
    public String timKiemtongtien(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien(tongTien,0);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/index";
    }
    @GetMapping("/timkiemtendh1")
    public String detaildh(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP4(ten,4);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/dahuy";
    }
    @GetMapping("/timkiemngaydh1")
    public String timKiemTheoNgaydh(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat4(ngaydat,4);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/dahuy";
    }
    @GetMapping("/timkiemtongtiendh1")
    public String timKiemtongtiendh(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien4(tongTien,4);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/dahuy";
    }
    @GetMapping("/timkiemtenvc1")
    public String detailvc(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP1(ten,1);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/vanchuyen";
    }
    @GetMapping("/timkiemngayvc1")
    public String timKiemTheoNgayvc(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat1(ngaydat,1);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/vanchuyen";
    }
    @GetMapping("/timkiemtongtienvc1")
    public String timKiemtongtienvc(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien1(tongTien,1);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/vanchuyen";
    }
    @GetMapping("/timkiemtenxn1")
    public String detailxn(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP2(ten,2);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/choxacnhan";
    }
    @GetMapping("/timkiemngayxn1")
    public String timKiemTheoNgayxn(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat2(ngaydat,2);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/choxacnhan";
    }
    @GetMapping("/timkiemtongtienxn1")
    public String timKiemtongtienxn(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien2(tongTien,2);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/choxacnhan";
    }
    @GetMapping("/timkiemtentc1")
    public String detailtc(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP3(ten,3);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/thanhcong";
    }
    @GetMapping("/timkiemngaytc1")
    public String timKiemTheoNgaytc(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat3(ngaydat,3);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/thanhcong";
    }
    @GetMapping("/timkiemtongtientc1")
    public String timKiemtongtientc(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien3(tongTien,3);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/thanhcong";
    }
   @GetMapping("/timkiemtenxn2")
public String detailxn1(@RequestParam("ten")String ten, Model model){
    List<DonHangChiTiet> list=donHangChiTietService.findTenSP5(ten,5);
    model.addAttribute("list",list);
    return "admin/don-hang-chi-tiet/xacnhan";
}
    @GetMapping("/timkiemngayxn2")
    public String timKiemTheoNgayxn1(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat5(ngaydat,5);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/xacnhan";
    }
    @GetMapping("/timkiemtongtienxn2")
    public String timKiemtongtienxn1(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien5(tongTien,5);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/xacnhan";
    }
    @GetMapping("/timkiemtenxn3")
    public String detailxn3(@RequestParam("ten")String ten, Model model){
        List<DonHangChiTiet> list=donHangChiTietService.findTenSP6(ten,6);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/choxacnhanhuy";
    }
    @GetMapping("/timkiemngayxn3")
    public String timKiemTheoNgayxn3(@RequestParam("ngaydat") LocalDate ngaydat, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findNgayDat6(ngaydat,6);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/choxacnhanhuy";
    }
    @GetMapping("/timkiemtongtienxn3")
    public String timKiemtongtienxn3(@RequestParam("tongTien") Float tongTien, Model model) {
        List<DonHangChiTiet> list = donHangChiTietService.findTongTien6(tongTien,6);
        model.addAttribute("list", list);
        return "admin/don-hang-chi-tiet/choxacnhanhuy";
    }
    @GetMapping("/detaildh/{donHang}")
    public String detail(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/chitiet";
    }
    @GetMapping("/detaildh1/{donHang}")
    public String detail1(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/chitiet";
    }
    @GetMapping("/detaildh2/{donHang}")
    public String detail2(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/chitiet";
    }
    @GetMapping("/detaildh3/{donHang}")
    public String detail3(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/chitiet";
    }
    @GetMapping("/detaildh4/{donHang}")
    public String detail4(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/chitiet";
    }
    @GetMapping("/detaildh5/{donHang}")
    public String detail5(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/chitiet";
    }
    @GetMapping("/detaildh6/{donHang}")
    public String detail6(@PathVariable("donHang")UUID donHang,Model model){
        List<DonHangChiTiet>list=donHangChiTietService.finDonHang(donHang);
        model.addAttribute("list",list);
        return "admin/don-hang-chi-tiet/chitiet";
    }
}
