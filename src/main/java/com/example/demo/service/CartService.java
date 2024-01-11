
package com.example.demo.service;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CartService {
    void remove(int id);
    void add(UUID sanPhamID);
    Map<GioHang, Integer> getProductInCart();
    GioHang detail(int gioHangID);
    List<GioHang> getAll();
    GioHang insert(GioHang gioHang,String ten,String anh,int size,int mausac);
    GioHang update(int gioHangID,GioHang gioHang);
    void delete(int gioHangID);
    List<GioHang>getAllByKhachHang(String username);
    List<GioHang>timkiem(String ten,String username);
    Page<GioHang>page(String name,int pageNumber, int pageSize);
}

