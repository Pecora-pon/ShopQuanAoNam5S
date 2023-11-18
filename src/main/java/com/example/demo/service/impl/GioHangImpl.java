package com.example.demo.service.impl;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.Size;
import com.example.demo.repository.GioHangRepo;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.SizeService;
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
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private SizeService sizeService;


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
    public GioHang detail(int gioHangID) {
        return gioHangRepo.getById(gioHangID);
    }

    @Override
    public List<GioHang> getAll() {
        return gioHangRepo.findAll();
    }

    @Override
    public GioHang insert(GioHang gioHang,UUID sanPhamID) {
        SanPham sanPham=sanPhamRepo.findById(sanPhamID).orElse(null);
        System.out.println(sanPham);
        int mausac=sanPham.getMauSac().getMauSacID();
        sanPham.getMauSac().setMauSacID(mausac);
        gioHang.setSanPham(sanPham);
        int sl=gioHang.getSoLuongDat();
        double gia=sanPham.getGiaSanPham();
        if(gioHang.getTongTien()==null){
            gioHang.setTongTien(gia*sl);
        }

      return gioHangRepo.save(gioHang);
    }

    @Override
    public GioHang update(int gioHangID, GioHang gioHang) {
         GioHang gh=gioHangRepo.findById(gioHangID).orElse(null);
         UUID sp=gh.getSanPham().getSanPhamID();
         int sl=gh.getSoLuongDat();
        System.out.println("sosaljf;áljf"+sl);
         gioHang.setSoLuongDat(sl);
        sanPhamService.capnhat(sp,sl);
        return  gioHangRepo.save(gioHang);
    }

    @Override
    public void delete(int gioHangID) {
        gioHangRepo.deleteById(gioHangID);
    }

    @Override
    public List<GioHang> getAllByKhachHang(String username) {
        return gioHangRepo.findByKhachHang_Username(username);
    }
}
