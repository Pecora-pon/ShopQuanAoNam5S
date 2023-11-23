package com.example.demo.service;

import com.example.demo.entity.*;

import java.util.List;
import java.util.UUID;

public interface ThanhToanService {
    List<GioHang> detail(List<Integer> gioHangID);
    SanPham deltail1(UUID sanPham);
//    KhachHang kh(String ten);
    DonHang themmoi(DonHang donHang, List<Integer> gioHangID);
    DonHang themmoingay(DonHang donHang,UUID sanPham);

}
