package com.example.demo.service;

import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ShopService {
    Page<SanPham> getPage(int pageNumber, int pageSize);

    Page<SanPham> getPages(int page, int size, String thuonghieuID, String sizeID, String tenSanPham);

    Page<SanPham> findByMauSacID(int page, int size, String mauSacID);

    Page<SanPham> findByChatLieuID(int page, int size, String chatLieuID);

    Page<SanPham> findBySizeID(int page, int size, String sizeID);

    Page<SanPham> findByTenSanPham(int page, int size, String tenSanPham);

    List<SanPham> findByHinhAnhURL(String hinhAnhURL);

    Page<SanPham> findByProductInPriceRange(int page, int size, Double minPrice, Double maxPrice);

    List<SanPham> getAll();

    SanPham detail(UUID sanPhamID);

    SanPham themgio(UUID sanPhamID);



}
