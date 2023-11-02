
package com.example.demo.service;

import com.example.demo.entity.GioHang;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CartService {
    void remove(int id);

    void add(UUID sanPhamID);

    Map<GioHang, Integer> getProductInCart();

    List<GioHang> getAll();
}

