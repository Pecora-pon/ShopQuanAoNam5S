package com.example.demo.repository;

import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.GioHang;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DonHangChiTietRepo extends JpaRepository<DonHangChiTiet, Integer> {
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =0 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =1 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username1(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =2 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username2(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =3 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username3(String username);
    @Query("select p from DonHangChiTiet p WHERE p.donHang.khachHang.username =:username and p.trangThai =4 order by p.donHangChiTietID desc")
    List<DonHangChiTiet>findByDonHang_KhachHang_Username4(String username);
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 1 where donHangID =:donHangID",nativeQuery = true)
    void chuyenTrangThai(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =0 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getAlll();
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 2 where donHangID =:donHangID",nativeQuery = true)
    void chuyensangxn(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =1 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getAll();
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 3 where donHangID =:donHangID",nativeQuery = true)
    void chuyensangtc(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =2 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getA();
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =3 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getHuy();
    @Query(value = "SELECT * FROM DonHangChiTiet d WHERE d.donHangID = :donHangID",nativeQuery = true)
    List<DonHangChiTiet> findById(@Param("donHangID") UUID donHangChiTietID);
    @Transactional
    @Modifying
    @Query(value = "Update DonHangChiTiet set trangThai = 4 where donHangID =:donHangID",nativeQuery = true)
    void chuyensanghuy(@Param("donHangID") UUID donHangChiTietID);
    @Query(value = "select * from DonHangChiTiet p WHERE p.trangThai =4 order by p.donHangChiTietID desc",nativeQuery = true)
    List<DonHangChiTiet> getHuyy();
}
