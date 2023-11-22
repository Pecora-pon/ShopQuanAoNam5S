package com.example.demo.service;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.KhachHang;

import java.util.List;

public interface ThanhToanService {
    List<GioHang> detail(List<Integer> gioHangID);
//    KhachHang kh(String ten);
    DonHang themmoi(DonHang donHang, List<Integer> gioHangID);
}
