package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.Size;
import com.example.demo.service.MauSacService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ShopService;
import com.example.demo.service.SizeService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
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

    @RequestMapping("/list-san-pham")
    public String getAll(Model model) {
        List<SanPham> sanPhams = shopService.getAll();
        model.addAttribute("listSanPham", sanPhams);
        model.addAttribute("sp", new SanPham());
        return "shop/san-pham";
    }
    @RequestMapping("/list-san-pham-detail/{sanPhamID}")
    public String detail(@PathVariable("sanPhamID") UUID sanPhamID,Model model){
        SanPham sanPham = shopService.detail(sanPhamID);
        model.addAttribute("sp",sanPham);
        return "shop/san-pham-detail";
    }

    @RequestMapping(value = "/list-san-pham/page", method = RequestMethod.GET)
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "9") int size,
                       Model model,
                       @Param("thuonghieuid") String thuonghieuid,
                       @Param("sizeid") String sizeid,
                       @Param("tensanpham") String tensanpham,
                       @Param("mausacid") String mausacid,
                       @Param("chatlieuid") String chatlieuid,
                       @Param("minPrice")  Double minPrice,
                       @Param("getimage/hinhAnhURL") String hinhAnhURL,
                       @Param("maxPrice") Double maxPrice) {
        Page<SanPham> page1 = shopService.getPage(page, size);
        List<SanPham> sanPhams = page1.getContent();
        List<SanPham> sanPhams1 = shopService.getAll();
        if (thuonghieuid != null) {
            sanPhams = this.shopService.findByThuongHieu(thuonghieuid);
        }
        if (sizeid != null) {
            sanPhams = this.shopService.findBySizeID(sizeid);
        }
        if (tensanpham != null) {
            sanPhams = this.shopService.findByTenSanPham(tensanpham);
        }
        if (mausacid != null) {
            sanPhams = this.shopService.findByMauSacID(mausacid);
        }
        if (chatlieuid != null) {
            sanPhams = this.shopService.findByChatLieuID(chatlieuid);
        }if(minPrice != null && maxPrice !=null){
            sanPhams = this.shopService.findByProductInPriceRange(minPrice,maxPrice);

        }if(hinhAnhURL != null){
            sanPhams =this.shopService.findByHinhAnhURL(hinhAnhURL);
        }

        int totalItems = sanPhams1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listSanPham", sanPhams);
        model.addAttribute("sp", new SanPham());
        return "redirect:/list-san-pham";


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
        model.addAttribute("listMauSac",list2);
        model.addAttribute("listSize",list1);
        model.addAttribute("listSanPham",list);
        model.addAttribute("sp",sanPham);
        return "shop/san-pham-detail";
   }
}

