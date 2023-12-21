package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.GioHangRepo;
import com.example.demo.repository.MauSacRepo;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.repository.SizeRepo;
import com.example.demo.service.CartService;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    private SizeRepo sizeRepo;
    @Autowired
    private MauSacRepo mauSacRepo;


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
    public GioHang insert(GioHang gioHang, UUID sanPhamID) {
        SanPham sanPham = sanPhamRepo.findById(sanPhamID).orElse(null);

        if (sanPham == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return null;
        }

        int slton = sanPham.getSoLuongTon();
        int sl = gioHang.getSoLuongDat();
        String tenSanPham = sanPham.getTenSanPham();

        Optional<GioHang> existingItemOptional = gioHangRepo.findBySanPham_TenSanPhamAndTrangThaiAndSanPham_Size_SizeIDAndSanPham_MauSac_MauSacIDAndKhachHang_KhachHangId(tenSanPham, gioHang.getTrangThai(),sanPham.getSize().getSizeID(),sanPham.getMauSac().getMauSacID(),gioHang.getKhachHang().getKhachHangId());

        if (existingItemOptional.isPresent()) {
            GioHang existingItem = existingItemOptional.get();
            int existingQuantity = existingItem.getSoLuongDat() + sl;
            if (slton < existingQuantity) {
                System.out.println("Số lượng tồn của sản phẩm không đủ");
                return null;
            }
            existingItem.setSoLuongDat(existingQuantity);
            float gia = sanPham.getGiaSanPham();
            float tongTien = existingItem.getTongTien() + (gia * sl);
            existingItem.setTongTien(tongTien);

            return gioHangRepo.save(existingItem);
        } else {
            if (slton < sl) {
                System.out.println("Số lượng tồn của sản phẩm không đủ");
                return null;
            } else {
//                int mausac = sanPham.getMauSac().getMauSacID();
                gioHang.setTrangThai(0);
//                sanPham.getMauSac().setMauSacID(mausac);
                gioHang.setSanPham(sanPham);
                float gia = sanPham.getGiaSanPham();
                gioHang.setTongTien(gia * sl);
            }

            return gioHangRepo.save(gioHang);
        }
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
