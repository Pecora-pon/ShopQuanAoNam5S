package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
<<<<<<< HEAD
    @Query("SELECT n FROM KhachHang n WHERE n.hoTen LIKE %?1%")
    List<KhachHang> searchByHoTenOrTenDangNhap(String keyword);

=======
<<<<<<< HEAD
    @Query("SELECT n FROM KhachHang n WHERE n.hoTen LIKE %?1%")
    List<KhachHang> searchByHoTenOrTenDangNhap(String keyword);
=======
    KhachHang findByTenDangNhap(String tenDangNhap);
>>>>>>> 2e4f6e7d57debb762378d8ed3b259c94427d5a8a
>>>>>>> 32f04127f71ac1add5b83ad6c6963e7181614f86
}
