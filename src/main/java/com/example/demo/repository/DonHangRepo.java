package com.example.demo.repository;

import com.example.demo.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DonHangRepo extends JpaRepository<DonHang, UUID> {
    @Query("SELECT d FROM DonHang d WHERE d.tenKhach LIKE %?1%")
    List<DonHang> searchByTenKhach(String keyword);
    @Query("Select d from DonHang d where d.trangThai =1")
    List<DonHang> ban();
    @Query("SELECT  d from DonHang d where d.donHangID =:donHangID")
    DonHang timdon(@Param("donHangID") UUID id);
    boolean existsByTenKhach(String tenKhach);
}
