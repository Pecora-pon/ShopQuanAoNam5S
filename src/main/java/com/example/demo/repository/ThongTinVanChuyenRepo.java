package com.example.demo.repository;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.Size;
import com.example.demo.entity.ThongTinVanChuyen;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThongTinVanChuyenRepo extends JpaRepository<ThongTinVanChuyen,Integer> {
    @Query("SELECT ttvc FROM ThongTinVanChuyen ttvc WHERE ttvc.diaChi LIKE %?1%")
    List<ThongTinVanChuyen> searchByDiaChi(String keyword);
    Optional<ThongTinVanChuyen> findById(Integer integer);
    List<ThongTinVanChuyen>findByKhachHang_Username(String username);
    @Transactional
    @Modifying
    @Query(value = "Update ThongTinVanChuyen set trangThai = 1 where thongTinVanChuyenID =:thongTinVanChuyenID",nativeQuery = true)
    void deleteByI(@Param("thongTinVanChuyenID") int chatLieuID);
    @Query(value = "select * from ThongTinVanChuyen p WHERE p.trangThai =0 order by p.thongTinVanChuyenID desc",nativeQuery = true)
    List<ThongTinVanChuyen> getAll();
}
