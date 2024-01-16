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
                    if (newSoLuong >= 1) {
                        gioHang1.setSoLuongDat(newSoLuong);
                    } else {
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
    public SanPham deltail1(String ten,String anh,int size,int mausac, int sl) {
        SanPham sanPham1 = sanPhamRepo.findByTenSanPhamAndHinhAnhURLAndSanPham_Size_SizeIDAndSanPham_MauSac_MauSacID(ten,anh,size,mausac);

        return sanPham1;
    }

    @Override
    public DonHang themmoi(DonHang donHang, List<Integer> gioHangID, float tt,int trang) {
        donHang.setNgayDatHang(LocalDate.now());
        donHang.setTrangThai(0);
        DonHang donHang1 = donHangRepo.save(donHang);
        List<DonHangChiTiet> donHangChiTiets = new ArrayList<>();

//        GiamGia giamGia=giamGiaRepo.findById(gg).orElse(null);

            for (Integer dh : gioHangID) {
                GioHang gioHang = gioHangRepo.getById(dh);
                gioHang.getSanPham().getSanPhamID();
                UUID sp = gioHang.getSanPham().getSanPhamID();
                gioHang.getSoLuongDat();


                int sl = gioHang.getSoLuongDat();
                System.out.println(gioHang);
                DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
                donHangChiTiet.setSoLuong(gioHang.getSoLuongDat());
                donHangChiTiet.setDonHang(donHang1);
                donHangChiTiet.setTrangThai(trang);
                donHangChiTiet.setTongTien(tt);
                donHangChiTiet.setSanPham(gioHang.getSanPham());
                donHangChiTiets.add(donHangChiTiet);
//                sanPhamService.capnhat(sp, sl);
            }


        donHangChiTietRepo.saveAll(donHangChiTiets);
        return donHang1;

    }

    @Override
    public DonHang themmoingay(DonHang donHang, UUID sanPham, int sl, float tt,int trangthai) {
        donHang.setNgayDatHang(LocalDate.now());
        donHang.setTrangThai(0);
        DonHang donHang1 = donHangRepo.save(donHang);
        SanPham sanPham1 = sanPhamRepo.findById(sanPham).orElse(null);

//        GiamGia giamGia=giamGiaRepo.findById(gg).orElse(null);

        List<DonHangChiTiet> donHangChiTiets = new ArrayList<>();

        DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
        donHangChiTiet.setSanPham(sanPham1);
        donHangChiTiet.setSoLuong(sl);
        donHangChiTiet.setTongTien(tt);
        donHangChiTiet.setTrangThai(trangthai);
        donHangChiTiet.setDonHang(donHang1);
        donHangChiTietRepo.save(donHangChiTiet);
        sanPhamService.capnhat(sanPham, sl);
//

//        if (donHangChiTiet != null) {
//            donHangChiTiet.setDonHang(donHang1);
//            donHangChiTiets.add(donHangChiTiet);
//        }
        return donHang1;
    }
    @Override
    public DonHang themmoingay1(DonHang donHang, UUID sanPham, int sl, float tt,int trangthai) {
        donHang.setNgayDatHang(LocalDate.now());
        donHang.setTrangThai(0);
        DonHang donHang1 = donHangRepo.save(donHang);
        SanPham sanPham1 = sanPhamRepo.findById(sanPham).orElse(null);

//        GiamGia giamGia=giamGiaRepo.findById(gg).orElse(null);

        List<DonHangChiTiet> donHangChiTiets = new ArrayList<>();

        DonHangChiTiet donHangChiTiet = new DonHangChiTiet();
        donHangChiTiet.setSanPham(sanPham1);
        donHangChiTiet.setSoLuong(sl);
        donHangChiTiet.setTongTien(tt);
        donHangChiTiet.setTrangThai(trangthai);
        donHangChiTiet.setDonHang(donHang1);
        donHangChiTietRepo.save(donHangChiTiet);
//        sanPhamService.capnhat(sanPham, sl);
//

//        if (donHangChiTiet != null) {
//            donHangChiTiet.setDonHang(donHang1);
//            donHangChiTiets.add(donHangChiTiet);
//        }
        return donHang1;
    }
    @Override
    public DonHang themmoi2(DonHang donHang, List<GioHang> gioHangList, float tt, DonHangChiTiet donHangChiTiet,int trang) {
        donHang.setNgayDatHang(LocalDate.now());
        donHang.setTrangThai(0);

        // Lưu đối tượng DonHang vào cơ sở dữ liệu
        DonHang donHang1 = donHangRepo.save(donHang);

        List<DonHangChiTiet> donHangChiTiets = new ArrayList<>();

        // Kiểm tra nếu giảm giá không phải là null
//        if (donHang1.getGiamGia() != null) {
//            int gg = donHang1.getGiamGia().getGiamGiaID();
//            GiamGia giamGia = giamGiaRepo.findById(gg).orElse(null);

        for (GioHang gioHang : gioHangList) {
            UUID sp = gioHang.getSanPham().getSanPhamID();
            int sl = gioHang.getSoLuongDat();

            DonHangChiTiet donHangChiTietItem = new DonHangChiTiet();
            donHangChiTietItem.setSoLuong(gioHang.getSoLuongDat());
            donHangChiTietItem.setDonHang(donHang1);
            donHangChiTietItem.setTrangThai(trang);
            donHangChiTietItem.setTongTien(tt);
            donHangChiTietItem.setSanPham(gioHang.getSanPham());
            donHangChiTiets.add(donHangChiTietItem);

            sanPhamService.capnhat(sp, sl);
        }

//        GiamGia giamGia=giamGiaRepo.findById(gg).orElse(null);

        // Thêm đối tượng DonHangChiTiet từ session vào danh sách
//        if (donHangChiTiet != null) {
//            donHangChiTiet.setDonHang(donHang1);
//            donHangChiTiets.add(donHangChiTiet);
//
//        }
            // Lưu đối tượng DonHangChiTiet vào cơ sở dữ liệu
            donHangChiTietRepo.saveAll(donHangChiTiets);

            return donHang1;
        }
//    @Override
//    public KhachHang kh(String ten) {
//

}


