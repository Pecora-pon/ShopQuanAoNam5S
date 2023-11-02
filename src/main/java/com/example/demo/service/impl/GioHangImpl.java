package com.example.demo.service.impl;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.GioHangRepo;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class GioHangImpl implements CartService {
    private Map<GioHang,Integer> gioHangIntegerMap = new HashMap<>();
    @Autowired
    private GioHangRepo gioHangRepo;
    @Autowired
    private SanPhamRepo sanPhamRepo;


    @Override
    public void remove(int id) {
        
    }

    @Override
    public void add(UUID sanPhamID) {
        SanPham sanPham = sanPhamRepo.findById(sanPhamID).get();
        if(sanPham !=null){
            
        }

    }



    @Override
    public Map<GioHang, Integer> getProductInCart() {
        return null;
    }

    @Override
    public List<GioHang> getAll() {
        return gioHangRepo.findAll();
    }
}
