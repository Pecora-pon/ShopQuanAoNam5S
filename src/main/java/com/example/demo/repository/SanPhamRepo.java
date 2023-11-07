package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, UUID> {
@Query("select sp from SanPham sp order by sp.ngayTao desc ")
    List<SanPham> sapxep();
}
