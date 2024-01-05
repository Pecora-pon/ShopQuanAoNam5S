package com.example.demo.controller;

import com.example.demo.config.SanPhamExel;
import com.example.demo.entity.*;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.*;
import com.example.demo.service.impl.FileUploaderServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class SanPhamController {
@Autowired
    SanPhamService sanPhamService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    SizeService sizeService;
    @Autowired
    ChatLieuService chatLieuService;
    @Autowired
    ThuongHieuService thuongHieuService;
    @Autowired
    FileUploaderServiceImpl fileUploaderService;
    @GetMapping("/san-pham")
    private String getAll(Model model){
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham", sanPhamList);
        model.addAttribute("sp",new SanPham());
        return "sanpham/sanpham";
    }
    @RequestMapping(value = "/san-pham-add", method = RequestMethod.POST)
    public String addSanPham(@RequestParam("hinhAnhURL") MultipartFile file,
                             @Valid @ModelAttribute("sp") SanPham sanPham,
                             BindingResult result, Model model,RedirectAttributes redirectAttributes) {
        
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                sanPham.setHinhAnhURL(file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        Respon<SanPham> respon = sanPhamService.add(sanPham);
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);

        model.addAttribute("sp", new SanPham());
        redirectAttributes.addFlashAttribute("repon", respon);
        model.addAttribute("listSanPham", sanPhamList);
        return "redirect:/san-pham/page";
    }
    @RequestMapping("/san-pham/delete/{sanPhamID}")
    public String delete(@PathVariable("sanPhamID")UUID sanPhamID){
        sanPhamService.delete(sanPhamID);
        return "redirect:/san-pham/page";
    }
    @RequestMapping("/san-pham-view-update/{sanPhamID}")
    public String voidUpdate(@PathVariable("sanPhamID")UUID sanPhamID,Model model){
        SanPham sanPham=sanPhamService.detail(sanPhamID);
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        List<SanPham> sanPhamList=sanPhamService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham",sanPhamList);
        model.addAttribute("sp",sanPham);
        return "sanpham/sanpham-update";
    }
    @RequestMapping(value = "/san-pham/update/{sanPhamID}", method = RequestMethod.POST)
    public String update(@PathVariable("sanPhamID") UUID sanPhamID, SanPham sanPham, Model model, RedirectAttributes redirectAttributes) {
       Respon<SanPham>respon= sanPhamService.update(sanPhamID, sanPham);
       redirectAttributes.addFlashAttribute("repon",respon);
        return "redirect:/san-pham/page";
    }
    @RequestMapping(value = "/san-pham/page", method = RequestMethod.GET)
    public String page(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "6") int size,
                       Model model,
                       @Param("keyword") String keyword,
                       @Param("getimage/hinhAnhURL")String hinhAnhURL) {
        Page<SanPham> page1 = sanPhamService.getPage(page - 1, size);
        List<SanPham> sanPhamList= page1.getContent();
        List<SanPham> nhapKhoList1 = sanPhamService.getAll();
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();

        int totalItems = nhapKhoList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listSanPham", sanPhamList);
        model.addAttribute("sp", new SanPham());
        return "sanpham/sanpham";
    }
    @GetMapping("/uploadexel")
    public String getupload(@ModelAttribute("sp") SanPham sanPham){
        return "admin/uploadexel";
    }
    @PostMapping("/uploadexel")
    public String uploadexel(@RequestParam("fileLoaction") MultipartFile file) {
        try {
            fileUploaderService.uploadFile(file);
        } catch (IOException e) {
            // Xử lý IOException nếu cần thiết
            e.printStackTrace();
        }
        return "admin/uploadexel";
    }
//    @GetMapping("/san-pham-gio/{sanPhamID}")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    public String sanphamgio(@PathVariable("sanPhamID")UUID sanPhamID,Model model){
//       SanPham sanPham=sanPhamService.themgio(sanPhamID);
//        model.addAttribute("gh",sanPham);
//        return "shop/gio-hangdemo";
//    }
@GetMapping("/timkiemmssp")
public String ms(@RequestParam("mauSac") int mausac, Model model) {
    List<SanPham> sanPhamList = sanPhamService.findByMauSacID(mausac);
    List<MauSac> mauSacList = mauSacService.getAll();
    List<ChatLieu> chatLieuList = chatLieuService.getAll();
    List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
    List<Size> sizeList = sizeService.getAll();
    model.addAttribute("listMauSac", mauSacList);
    model.addAttribute("listChatLieu", chatLieuList);
    model.addAttribute("listThuongHieu", thuongHieuList);
    model.addAttribute("listSize", sizeList);
    model.addAttribute("listSanPham", sanPhamList);
    model.addAttribute("sp",new SanPham());
    return "sanpham/sanpham";
}
@GetMapping("/timkiemtensp")
    public String timkiem(@RequestParam("tenSanPham") String tenSanPham,Model model){
        List<SanPham>list=sanPhamService.findtenSanPham(tenSanPham);
    List<MauSac> mauSacList = mauSacService.getAll();
    List<ChatLieu> chatLieuList = chatLieuService.getAll();
    List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
    List<Size> sizeList = sizeService.getAll();
    model.addAttribute("listMauSac", mauSacList);
    model.addAttribute("listChatLieu", chatLieuList);
    model.addAttribute("listThuongHieu", thuongHieuList);
    model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham",list);
        model.addAttribute("sp",new SanPham());
        return "sanpham/sanpham";
}
    @GetMapping("/timkiemsize")
    public String timkiemsize(@RequestParam("size") int size,Model model){
        List<SanPham>list=sanPhamService.findBySizeID(size);
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham",list);
        model.addAttribute("sp",new SanPham());
        return "sanpham/sanpham";
    }
    @GetMapping("/timkiemchatlieu")
    public String timkiemchatlieu(@RequestParam("chatLieu") int chatLieu,Model model){
        List<SanPham>list=sanPhamService.findByChatLieuID(chatLieu);
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham",list);
        model.addAttribute("sp",new SanPham());
        return "sanpham/sanpham";
    }
    @GetMapping("/timkiemthuonghieu")
    public String timkiemthuonghieu(@RequestParam("thuongHieu") int thuongHieu,Model model){
        List<SanPham>list=sanPhamService.findByThuongHieuID(thuongHieu);
        List<MauSac> mauSacList = mauSacService.getAll();
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        List<ThuongHieu> thuongHieuList = thuongHieuService.getAll();
        List<Size> sizeList = sizeService.getAll();
        model.addAttribute("listMauSac", mauSacList);
        model.addAttribute("listChatLieu", chatLieuList);
        model.addAttribute("listThuongHieu", thuongHieuList);
        model.addAttribute("listSize", sizeList);
        model.addAttribute("listSanPham",list);
        model.addAttribute("sp",new SanPham());
        return "sanpham/sanpham";
    }
    @GetMapping("/san-pham/exportexel")
    public void exportexel(HttpServletResponse response)throws IOException{
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=sanpham_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<SanPham> listSanPham = sanPhamService.getAll();

        SanPhamExel excelExporter = new SanPhamExel(listSanPham);

        excelExporter.export(response);

    }
}
