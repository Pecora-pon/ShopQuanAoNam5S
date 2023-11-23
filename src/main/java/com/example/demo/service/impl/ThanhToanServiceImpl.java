package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.DonHangService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    public List<GioHang> detail(List<Integer> gioHangID) {
    List<GioHang>list=new ArrayList<>();
      for(Integer gioHang:gioHangID){
          GioHang gioHang1=gioHangRepo.getById(gioHang);
          list.add(gioHang1);
      }
        return list;
    }

    @Override
    public SanPham deltail1(UUID sanPham) {
       SanPham sanPham1= sanPhamRepo.findById(sanPham).orElse(null);
        return sanPham1;
    }

    @Override
    public DonHang themmoi(DonHang donHang, List<Integer> gioHangID) {
        donHang.setNgayDatHang(LocalDate.now());
        DonHang donHang1 = donHangRepo.save(donHang);
        for (Integer dh : gioHangID) {
                GioHang gioHang = gioHangRepo.getById(dh);
                System.out.println("lsdjfja;gj"+gioHang.getGioHangID());
                gioHang.getSanPham().getSanPhamID();
                UUID sp= gioHang.getSanPham().getSanPhamID();
                gioHang.getSoLuongDat();
                int sl=gioHang.getSoLuongDat();
                System.out.println(gioHang);
                DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
                donHangChiTiet.setSoLuong(gioHang.getSoLuongDat());
                donHangChiTiet.setDonHang(donHang1);
                donHangChiTiet.setSanPham(gioHang.getSanPham());
                donHangChiTietRepo.save(donHangChiTiet);
                sanPhamService.capnhat(sp,sl);
        }
        return donHang1;
    }

    @Override
    public DonHang themmoingay(DonHang donHang, UUID sanPham) {
        donHang.setNgayDatHang(LocalDate.now());
        DonHang donHang1 = donHangRepo.save(donHang);
        SanPham sanPham1 = sanPhamRepo.findById(sanPham).orElse(null);
        DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
        donHangChiTiet.setSanPham(sanPham1);
        donHangChiTiet.setDonHang(donHang1);
        donHangChiTietRepo.save(donHangChiTiet);
//            sanPhamService.capnhat(sp,sl);
//
        return donHang1;
    }
//    @Override
//    public KhachHang kh(String ten) {
//
//    }

}
