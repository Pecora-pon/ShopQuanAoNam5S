package com.example.demo.repository;


import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien,Integer> {
    Optional<NhanVien> findByTenDangNhap(String tenDangNhap);
    @Query("SELECT n FROM NhanVien n WHERE n.hoTen LIKE %?1%")
    List<NhanVien> searchByHoTenOrTenDangNhap(String keyword);
    @Query("SELECT n FROM NhanVien n WHERE n.tenDangNhap =:tenDangNhap")
    NhanVien searchByTen(@Param("tenDangNhap") String tenDangNhap);

}
