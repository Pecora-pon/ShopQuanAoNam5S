package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;

import com.microsoft.sqlserver.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private ReviewNguoiDungService reviewNguoiDungService;

    //    @RequestMapping("/list-san-pham")
    //    public String getAll(Model model) {
    //        List<SanPham> sanPhams = shopService.getAll();
    //        model.addAttribute("listSanPham", sanPhams);
    //        model.addAttribute("sp", new SanPham());
    //        return "shop/san-pham";
    //    }
    @RequestMapping("/list-san-pham-detail/{sanPhamID}")
    public String detail(@PathVariable("sanPhamID") UUID sanPhamID,Model model){
        SanPham sanPham = shopService.detail(sanPhamID);
        model.addAttribute("sp",sanPham);
        return "shop/san-pham-detail";
    }
//    @RequestMapping("/san-pham-detail")
//    public String list4(Model model){
//        List<SanPham> sanPhams = sanPhamService.getTop4SanPhamByGiaThapNhat();
//        model.addAttribute("listSanPham4", sanPhams);
//        model.addAttribute("sp2", new SanPham());
//        return "shop/san-pham-detail";
//    }

 @RequestMapping(value = "/list-san-pham/page", method = RequestMethod.GET)
    public String page(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "9") int size,
                       Model model,
                       @Param("thuonghieuid") String thuonghieuid,
                       @Param("sizeid") String sizeid,
                       @Param("tensanpham") String tensanpham,
                       @Param("minPrice") Double minPrice,
                       @Param("maxPrice") Double maxPrice) {
        
        Page<SanPham> pageResult;

        if (minPrice != null && maxPrice != null) {
            pageResult = shopService.findByProductInPriceRange(page - 1, size, minPrice, maxPrice);
        } else if (thuonghieuid != null && sizeid != null && tensanpham != null) {
            pageResult = shopService.getPages(page - 1, size, thuonghieuid, sizeid, tensanpham);
        } else {
            pageResult = shopService.getPage(page - 1, size);
        }

        List<SanPham> sanPhamsOnPage = pageResult.getContent();
        int totalItems = (int) pageResult.getTotalElements();
        int itemsPerPage = size;
        int totalPages = pageResult.getTotalPages();
        int currentPage = page;

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listSanPham", sanPhamsOnPage);
        model.addAttribute("thuonghieuid", thuonghieuid);
        model.addAttribute("sizeid", sizeid);
        model.addAttribute("tensanpham", tensanpham);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("sp", new SanPham());

        return "shop/san-pham";
    }


   @GetMapping("/san-pham-detail/{sanPhamID}")
    public String san(@PathVariable("sanPhamID")UUID id,Model model){
        SanPham sanPham=shopService.themgio(id);
        List<SanPham>list=shopService.getAll();
        List<Size> list1=sizeService.getAll();
        List<MauSac>list2=mauSacService.getAll();
        List<ReviewNguoiDung> list3=reviewNguoiDungService.findBy(id);
        model.addAttribute("rv",list3);
        model.addAttribute("listMauSac",list2);
        model.addAttribute("listSize",list1);
        model.addAttribute("listSanPham",list);
        model.addAttribute("sp",sanPham);
        return "shop/san-pham-detail";
   }

    @GetMapping("/san-pham-tim/{tenSanPham}/{hinhAnhURL}/{sizeID}/{mauSacID}")
    public ResponseEntity<?> tim(
            @PathVariable("tenSanPham") String ten,
            @PathVariable("hinhAnhURL") String anh,
            @PathVariable("sizeID") int size,
            @PathVariable("mauSacID") int mausac,
            Model model
    ) {
        SanPham sanPham = sanPhamService.tim(ten, anh, size, mausac);

        if (sanPham != null) {
            Map<String, Object> result = new HashMap<>();
            result.put("sp", sanPham);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

