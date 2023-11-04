package com.example.demo.controller;

import com.example.demo.entity.DanhSachYeuThich;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.DanhSachYeuThichService;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("danh-sach-yt")
public class DanhSachYeuThichController {

    @Autowired
    private DanhSachYeuThichService danhSachYeuThichService;

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienthi(@ModelAttribute("yt")DanhSachYeuThich danhSachYeuThich, Model model){
        List<DanhSachYeuThich> list = danhSachYeuThichService.getAll();
      List<KhachHang> listKH = khachHangService.getAll();
        model.addAttribute("list", list);
       model.addAttribute("listkh",listKH);
        return "admin/danh-sach-yeu-thich/index";

    }

    @PostMapping("/add")
    public String add(@ModelAttribute("yt")DanhSachYeuThich danhSachYeuThich){
        List<KhachHang> listhk = khachHangService.getAll();
        danhSachYeuThichService.add(danhSachYeuThich);
        return "redirect:/danh-sach-yt/hien-thi";
    }

    @GetMapping("/delete/{danhSachYeuThichID}")
    public String delete(@PathVariable("danhSachYeuThichID") Integer DanhSachYTID){
        List<KhachHang> listkh = khachHangService.getAll();
        danhSachYeuThichService.delete(DanhSachYTID);
        return "redirect:/danh-sach-yt/hien-thi";
    }

    @RequestMapping("/danh-sach-yt/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<DanhSachYeuThich> nhanVienList = danhSachYeuThichService.findKhachHang(keyword);
        model.addAttribute("nv",nhanVienList);
        return "admin/danh-sach-yeu-thich/index";
    }

    @RequestMapping("/danh-sach-yt/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<DanhSachYeuThich> page1 = danhSachYeuThichService.getPage(page,size);
        List<DanhSachYeuThich> nhanVienList =page1.getContent();
        List<DanhSachYeuThich> nhanVienList1 = danhSachYeuThichService.getAll();
        if(keyword !=null){
            nhanVienList     = this.danhSachYeuThichService.findKhachHang(keyword);
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
        model.addAttribute("nv",new DanhSachYeuThich());
        return "admin/danh-sach-yeu-thich/index";

    }










}
