package com.example.demo.repository;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.GiamGiaChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamGiaChiTietRepository extends JpaRepository<GiamGiaChiTiet,Integer> {
    @Query("SELECT sp FROM SanPham sp WHERE sp.tenSanPham LIKE %?1%")
    List<GiamGiaChiTiet> searchBytenSanPham(String keyword);
}
