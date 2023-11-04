package com.example.demo.repository;


import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ReviewNguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewNguoiDungRepo extends JpaRepository<ReviewNguoiDung,Integer> {
    @Query("SELECT n FROM ReviewNguoiDung n WHERE n.khachHang LIKE %?1%")
    List<ReviewNguoiDung> searchByKhachHang(String keyword);

}
