package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ShopService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;
    @RequestMapping("/list-san-pham")
    public String getAll(Model model){
        List<SanPham> sanPhams = shopService.getAll();
        model.addAttribute("listSanPham",sanPhams);
        model.addAttribute("sp",new SanPham());
        return "shop/san-pham";
    }
    @RequestMapping(value = "/list-san-pham/page",method = RequestMethod.GET)
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "9") int size,
                       Model model,
                       @Param("thuonghieuid") String thuonghieuid){
        Page<SanPham> page1 = shopService.getPage(page,size);
        List<SanPham> sanPhams = page1.getContent();
        List<SanPham> sanPhams1 = shopService.getAll();
        if(thuonghieuid !=null){
            sanPhams = this.shopService.findByThuongHieu(thuonghieuid);
        }
        int totalItems = sanPhams1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listSanPham",sanPhams);
        model.addAttribute("sp",new SanPham());
        return "shop/san-pham";


    }
    @RequestMapping(value = "/list-san-pham/thuong-hieu/{thuonghieuid}")
    public String search(Model model,
                         @RequestParam("thuonghieuid") String thuongHieuID){
       List<SanPham> list = shopService.findByThuongHieu(thuongHieuID);
       model.addAttribute("listSanPham",list);
       return "shop/san-pham";
    }
}

