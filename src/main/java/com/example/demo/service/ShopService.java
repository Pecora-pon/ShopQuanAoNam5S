package com.example.demo.service;

import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ShopService {
    Page<SanPham> getPage(int pageNumber, int pageSize);

    List<SanPham> findByThuongHieu(String thuonghieuid);

    List<SanPham> findByMauSacID(String mauSacID);

    List<SanPham> findByChatLieuID(String chatLieuID);

    List<SanPham> findBySizeID(String sizeID);

    List<SanPham> findByTenSanPham(String tenSanPham);

    List<SanPham> findByProductInPriceRange(Double minPrice,Double maxPrice);

    List<SanPham> getAll();

    SanPham detail(UUID sanPhamID);

}
