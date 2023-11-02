package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, UUID> {
    @Query("SELECT sp FROM SanPham sp WHERE sp.thuongHieu LIKE %?1%")
    List<SanPham> findByThuongHieuID(String thuongHieuID);


    Optional<SanPham> findById(UUID sanPhamID);
}
