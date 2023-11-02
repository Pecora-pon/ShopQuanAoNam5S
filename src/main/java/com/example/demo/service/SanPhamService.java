
package com.example.demo.service;

import com.example.demo.entity.SanPham;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham add(SanPham sanPham);

    SanPham update(UUID sanPhamID,SanPham sanPham);

    void delete(UUID sanPhamID);

    SanPham detail(UUID sanPhamID);

    Optional<SanPham> findByID(UUID sanPhamID);
}
