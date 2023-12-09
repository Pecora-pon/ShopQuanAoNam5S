package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
//    @Transactional
//    @Modifying
//    @Query(value = "Update KhachHang set trangThai = 0 where khachHangID =:khachHangID",nativeQuery = true)
//    void deleteByI(@Param("khachHangID") int chatLieuID);
//    @Query(value = "select * from KhachHang p WHERE p.trangThai =1 order by p.khachHangID desc",nativeQuery = true)
//    List<KhachHang> getAll();
}

