package com.example.demo.repository;

import com.example.demo.entity.GiamGia;
import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamGiaRepo extends JpaRepository<GiamGia,Integer> {
    @Query("SELECT g FROM GiamGia g WHERE g.maGiamGia LIKE %?1%")
    List<GiamGia> searchBymaGiamGia(String keyword);
}
