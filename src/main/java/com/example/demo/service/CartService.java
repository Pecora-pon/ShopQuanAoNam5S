
package com.example.demo.service;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.KhachHang;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CartService {
    void remove(int id);
    void add(UUID sanPhamID);
    Map<GioHang, Integer> getProductInCart();
    GioHang detail(int gioHangID);
    List<GioHang> getAll();
    GioHang insert(GioHang gioHang,UUID sanPhamID);
    GioHang update(int gioHangID,GioHang gioHang);
    void delete(int gioHangID);
    List<GioHang>getAllByKhachHang(String username);
}

