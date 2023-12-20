package com.example.demo.service;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.DonHangChiTietRepo;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.repository.NhanVienRepo;
import com.example.demo.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThongKeService {
    @Autowired
    private NhanVienRepo nhanVienRepository;
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @Autowired
    private KhachHangRepo khachHangRepo;
    @Autowired
    private DonHangChiTietRepo donHangChiTietRepo;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public long countNhanVien() {
        return nhanVienRepository.count();
    }

    public List<SanPham> getAllSanPham() {
        return sanPhamRepo.findAll();
    }

    public long countSanPham() {
        return sanPhamRepo.count();
    }

    public List<KhachHang> getAllKhachHang() {
        return khachHangRepo.findAll();
    }

    public long countKhachHang() {
        return khachHangRepo.count();
    }

    public List<DonHangChiTiet> getAllDonHangChiTiet() {
        return donHangChiTietRepo.findAll();
    }

    public Float calculateTotalTongTien(int trangThai) {
        List<DonHangChiTiet> donHangChiTiets = donHangChiTietRepo.findByTrangThai(trangThai);
        float totalTongTien = 0;

        for (DonHangChiTiet donHangChiTiet : donHangChiTiets) {
            totalTongTien += donHangChiTiet.getTongTien();
        }

        return totalTongTien;
    }

    public List<Object[]> getTotalQuantityByMonthInYear2023() {
        return donHangChiTietRepo.getTotalQuantityByMonthInYear2023();
    }

    public List<Object[]> getTotalRevenueByMonthInYear2023() {
        return donHangChiTietRepo.getTotalRevenueByMonthInYear2023();
    }

    public long countOrdersByStatus() {
        return donHangChiTietRepo.countDistinctDonHangByTrangThai0();
    }

    public long countOrdersByStatus1() {
        return donHangChiTietRepo.countDistinctDonHangByTrangThai1();
    }

    public long countOrdersByStatus2() {
        return donHangChiTietRepo.countDistinctDonHangByTrangThai2();
    }

    public long countOrdersByStatus3() {
        return donHangChiTietRepo.countDistinctDonHangByTrangThai3();
    }

    public long countOrdersByStatus4() {
        return donHangChiTietRepo.countDistinctDonHangByTrangThai4();
    }

    public long countOrdersByStatus5() {
        return donHangChiTietRepo.countDistinctDonHangByTrangThai5();
    }

}
