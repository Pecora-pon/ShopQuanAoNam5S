package com.example.demo.service;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface BanHangService {
    DonHangChiTiet insert(DonHang donHang,DonHangChiTiet donHangChiTiet);

    void insertdh(DonHang donHang);
    List<DonHangChiTiet>getAll(UUID id);
    DonHangChiTiet insertsp(UUID sanPham, UUID donHang);
    SanPham detail(UUID id);
    List<DonHang>getAlll();
    List<DonHangChiTiet> banhang(List<Integer> donhang,float tong);
    void delete(int id);
    void delete1(UUID id);
    List<SanPham> findbyten(String ten);
}
