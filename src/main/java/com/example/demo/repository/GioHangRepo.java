
package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.KhachHang;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GioHangRepo extends JpaRepository<GioHang,Integer> {
List<GioHang>findByKhachHang_Username(String username);
    @Transactional
    @Modifying
    @Query(value = "Update GioHang set trangThai = 1 where gioHangID =:gioHangID",nativeQuery = true)
    void deleteByI(@Param("gioHangID") int gioHangID);
    @Query(value = "select * from GioHang p WHERE p.trangThai =0 order by p.gioHangID desc",nativeQuery = true)
    List<GioHang> getAll();
    List<GioHang> findByKhachHang(KhachHang khachHang);
    Optional<GioHang> findBySanPham_TenSanPhamAndTrangThai(String tenSanPham, int trangThai);


}

