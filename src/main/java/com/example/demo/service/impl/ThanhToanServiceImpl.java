package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.DonHangService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.responobject.Respon;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ThanhToanServiceImpl implements ThanhToanService {
@Autowired
    GioHangRepo gioHangRepo;
@Autowired
    KhachHangRepo khachHangRepo;
@Autowired
    DonHangRepo donHangRepo;
@Autowired
    DonHangChiTietRepo donHangChiTietRepo;
@Autowired
    GiamGiaRepo giamGiaRepo;
@Autowired
 ThongTinVanChuyenRepo thongTinVanChuyenRepo;
@Autowired
  SanPhamService sanPhamService;
@Autowired
  SanPhamRepo sanPhamRepo;
    @Override
    public List<GioHang> detail(List<Integer> gioHangID, Map<String, String> params) {
        List<GioHang> list = new ArrayList<>();

        for (Integer gioHang : gioHangID) {
            GioHang gioHang1 = gioHangRepo.getById(gioHang);
            int sl = gioHang1.getSoLuongDat();

            // Lấy giá trị soLuongDat từ map
            String paramName = "soLuongDat_" + gioHang;
            if (params.containsKey(paramName)) {
                try {
                    int newSoLuong = Integer.parseInt(params.get(paramName));
                    if(newSoLuong >=1) {
                        gioHang1.setSoLuongDat(newSoLuong);
                    }else {
                      continue;
                    }
                } catch (NumberFormatException e) {
                    // Xử lý nếu giá trị không phải số nguyên
                    e.printStackTrace();
                }
            }

            gioHangRepo.save(gioHang1);
            list.add(gioHang1);
        }

        return list;
    }
    @Override
    public SanPham deltail1(UUID sanPham,int sl) {
       SanPham sanPham1= sanPhamRepo.findById(sanPham).orElse(null);
        return sanPham1;
    }

    @Override
    public DonHang themmoi(DonHang donHang, List<Integer> gioHangID,float tt) {
        donHang.setNgayDatHang(LocalDate.now());
        donHang.setTrangThai(0);
        DonHang donHang1 = donHangRepo.save(donHang);
        List<DonHangChiTiet> donHangChiTiets=new ArrayList<>();
        int gg= donHang1.getGiamGia().getGiamGiaID();
        GiamGia giamGia=giamGiaRepo.findById(gg).orElse(null);
         if(tt>=500000) {
             float gia = giamGia.getSoTienGiam();
             for (Integer dh : gioHangID) {
                 GioHang gioHang = gioHangRepo.getById(dh);
                 gioHang.getSanPham().getSanPhamID();
                 UUID sp = gioHang.getSanPham().getSanPhamID();
                 gioHang.getSoLuongDat();


                 float tiendagiam = tt - gia;
                 int sl = gioHang.getSoLuongDat();
                 System.out.println(gioHang);
                 DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
                 donHangChiTiet.setSoLuong(gioHang.getSoLuongDat());
                 donHangChiTiet.setDonHang(donHang1);
                 donHangChiTiet.setTrangThai(0);
                 donHangChiTiet.setTongTien(tiendagiam);
                 donHangChiTiet.setSanPham(gioHang.getSanPham());
                 donHangChiTiets.add(donHangChiTiet);
                 sanPhamService.capnhat(sp, sl);
             }
         }else {
             float gia = giamGia.getSoTienGiam();
             for (Integer dh : gioHangID) {
                 GioHang gioHang = gioHangRepo.getById(dh);
                 gioHang.getSanPham().getSanPhamID();
                 UUID sp = gioHang.getSanPham().getSanPhamID();
                 gioHang.getSoLuongDat();


                 float tiendagiam = tt - gia;
                 int sl = gioHang.getSoLuongDat();
                 System.out.println(gioHang);
                 DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
                 donHangChiTiet.setSoLuong(gioHang.getSoLuongDat());
                 donHangChiTiet.setDonHang(donHang1);
                 donHangChiTiet.setTrangThai(0);
                 donHangChiTiet.setTongTien(tiendagiam);
                 donHangChiTiet.setSanPham(gioHang.getSanPham());
                 donHangChiTiets.add(donHangChiTiet);
                 sanPhamService.capnhat(sp, sl);
             }
         }

        donHangChiTietRepo.saveAll(donHangChiTiets);
        return donHang1;

    }

    @Override
    public DonHang themmoingay(DonHang donHang, UUID sanPham,int sl,float tt) {
        donHang.setNgayDatHang(LocalDate.now());
        donHang.setTrangThai(0);
        DonHang donHang1 = donHangRepo.save(donHang);
        SanPham sanPham1 = sanPhamRepo.findById(sanPham).orElse(null);
        int gg=donHang1.getGiamGia().getGiamGiaID();
        GiamGia giamGia=giamGiaRepo.findById(gg).orElse(null);
        if (tt>500000) {
            float gia = giamGia.getSoTienGiam();
            float tiendagiam=tt - gia;
            DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
            donHangChiTiet.setSanPham(sanPham1);
            donHangChiTiet.setSoLuong(sl);
            donHangChiTiet.setTongTien(tiendagiam);
            donHangChiTiet.setTrangThai(0);
            donHangChiTiet.setDonHang(donHang1);
            donHangChiTietRepo.save(donHangChiTiet);
            sanPhamService.capnhat(sanPham, sl);
//
        }else {
            float gia = giamGia.getSoTienGiam();
            float tiendagiam=tt-gia;
            DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
            donHangChiTiet.setSanPham(sanPham1);
            donHangChiTiet.setSoLuong(sl);
            donHangChiTiet.setTongTien(tiendagiam);
            donHangChiTiet.setTrangThai(0);
            donHangChiTiet.setDonHang(donHang1);
            donHangChiTietRepo.save(donHangChiTiet);
            sanPhamService.capnhat(sanPham, sl);
        }
        return donHang1;
    }
//    @Override
//    public KhachHang kh(String ten) {
//
//    }

}
