package com.example.demo.repository;


import com.example.demo.entity.NhanVien;
import com.example.demo.entity.ReviewNguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewNguoiDungRepo extends JpaRepository<ReviewNguoiDung,Integer> {
    @Query("SELECT n FROM ReviewNguoiDung n WHERE n.khachHang LIKE %?1%")
    List<ReviewNguoiDung> searchByKhachHang(String keyword);
    @Query("select p from ReviewNguoiDung p where p.sanPham.sanPhamID =:sanPhamID")
    List<ReviewNguoiDung>  findBySanPham_SanPhamID(@Param("sanPhamID") UUID id);

}
