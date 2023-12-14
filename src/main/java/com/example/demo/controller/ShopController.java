package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                       @Param("mausacid") String mausacid,
                       @Param("chatlieuid") String chatlieuid,
                       @Param("minPrice") Double minPrice,
                       @Param("getimage/hinhAnhURL") String hinhAnhURL,
                       @Param("maxPrice") Double maxPrice) {
        // Tính toán danh sách sản phẩm theo các tham số tìm kiếm
        List<SanPham> sanPhams = shopService.getAll(); // Default to all products



        // Phân trang
        Page<SanPham> pageResult = shopService.getPage(page - 1, size);
        List<SanPham> sanPhamsOnPage = pageResult.getContent();
        if (thuonghieuid != null) {
            sanPhamsOnPage = this.shopService.findByThuongHieu(thuonghieuid);
        }
        if (sizeid != null) {
            sanPhamsOnPage = this.shopService.findBySizeID(sizeid);
        }
        if (tensanpham != null) {
            sanPhamsOnPage = this.shopService.findByTenSanPham(tensanpham);
        }
        if (mausacid != null) {
            sanPhamsOnPage = this.shopService.findByMauSacID(mausacid);
        }
        if (chatlieuid != null) {
            sanPhamsOnPage = this.shopService.findByChatLieuID(chatlieuid);
        }
        if (minPrice != null && maxPrice != null) {
            sanPhamsOnPage = this.shopService.findByProductInPriceRange(minPrice, maxPrice);
        }

        int totalItems = sanPhams.size(); // Tổng số sản phẩm sau tất cả các bộ lọc
        int itemsPerPage = size;
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
        int currentPage = page;

        // Truyền các giá trị đến model
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listSanPham", sanPhamsOnPage);
        model.addAttribute("sp", new SanPham());

        return "shop/san-pham";
    }
    @RequestMapping(value = "/list-san-pham/thuong-hieu")
    public String searchThuongHieu(Model model,
                                   @Param("thuonghieuid") String thuongHieuID) {
        List<SanPham> list = shopService.getAll();
        if(thuongHieuID !=null){
            list = this.shopService.findByThuongHieu(thuongHieuID);
        }
        model.addAttribute("listSanPham", list);
        model.addAttribute("sp",new SanPham());
        return "shop/san-pham";
    }

    @RequestMapping(value = "/list-san-pham/size/{sizeid}")
    public String searchSize(Model model,
                             @RequestParam("sizeid") String sizeid) {
        List<SanPham> list = shopService.findBySizeID(sizeid);
        model.addAttribute("listSanPham", list);
        return "shop/san-pham";
    }

    @RequestMapping(value = "/list-san-pham/ten-san-pham/{tensanpham}")
    public String searchTenSanPham(Model model,
                                   @RequestParam("tensanpham") String tensanpham) {
        List<SanPham> list = shopService.findByTenSanPham(tensanpham);
        model.addAttribute("listSanPham", list);
        return "shop/san-pham";
    }

    @RequestMapping(value = "/list-san-pham/mau-sac/{mausacid}")
    public String searchMauSac(Model model,
                               @RequestParam("mausacid") String mausacid) {
        List<SanPham> list = shopService.findByMauSacID(mausacid);
        model.addAttribute("listSanPham", list);
        return "shop/san-pham";
    }

    @RequestMapping(value = "/list-san-pham/chat-lieu/{chatlieuid}")
    public String searchChatLieu(Model model,
                                 @RequestParam("chatlieuid") String chatlieuid) {
        List<SanPham> list = shopService.findByChatLieuID(chatlieuid);
        model.addAttribute("listSanPham", list);
        return "shop/san-pham";
    }

    @RequestMapping(value = "/list-san-pham/gia-san-pham")
    public String searchBetween(Model model,
                                 @RequestParam("minPrice") Double minPrice,
                                @RequestParam("maxPrice") Double maxPrice) {
        List<SanPham> list = shopService.findByProductInPriceRange(minPrice,maxPrice);
        model.addAttribute("listSanPham", list);
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
}

