package com.example.demo.repository;


import com.example.demo.entity.NhanVien;
import com.example.demo.entity.Size;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien,Integer> {
    boolean existsByHoTen(String tenSize);
    Page<NhanVien> findByTrangThai(Integer tinhTrang, Pageable pageable);
    Optional<NhanVien> findByTenDangNhapAndTrangThai(String tenDangNhap,int tinhtrang);
    @Query("SELECT n FROM NhanVien n WHERE n.hoTen LIKE %?1%")
    List<NhanVien> searchByHoTenOrTenDangNhap(String keyword);
    @Query("SELECT n FROM NhanVien n WHERE n.tenDangNhap =:tenDangNhap")
    NhanVien searchByTen(@Param("tenDangNhap") String tenDangNhap);
    @Transactional
    @Modifying
    @Query(value = "Update NhanVien set trangThai = 0 where nhanVienID =:nhanVienID",nativeQuery = true)
    void deleteByI(@Param("nhanVienID") int chatLieuID);
    @Query(value = "select * from NhanVien p WHERE p.trangThai =1 order by p.nhanVienID desc",nativeQuery = true)
    List<NhanVien> getAll();

}
