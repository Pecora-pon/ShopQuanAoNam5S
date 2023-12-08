package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
    Optional<KhachHang> findByusername(String username);
    @Query("SELECT k FROM KhachHang k WHERE k.hoTen LIKE %?1%")
    List<KhachHang> searchByHoTenOrUsername(String keyword);
    @Query("Select k from KhachHang k where k.username =:username")
    KhachHang findbyten(@Param("username")String username);

    KhachHang findByUsername(String username);
    Optional<KhachHang> findByEmail( String email);

    Optional<KhachHang> findBySoDienThoai(String soDienThoai);
    KhachHang findByemail(String email);
    KhachHang findByResetPasswordToken(String token);
}

