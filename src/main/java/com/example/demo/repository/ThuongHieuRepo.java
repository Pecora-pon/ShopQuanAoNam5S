package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.ThuongHieu;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuongHieuRepo extends JpaRepository<ThuongHieu,Integer> {
    @Query("Select th from ThuongHieu th where th.tenThuongHieu like %?1%")
    List<ThuongHieu> searchBy(String keyword);
    @Query("Select th from ThuongHieu th where th.tenThuongHieu =:tenThuongHieu")
    ThuongHieu searchByten(@Param("tenThuongHieu") String tenThuongHieu);
    @Query("Select th from ThuongHieu th order by th.thuongHieuID desc ")
    List<ThuongHieu> getAl();
    @Transactional
    @Modifying
    @Query(value = "Update ThuongHieu set trangThai = 1 where thuongHieuID =:thuongHieuID",nativeQuery = true)
    void deleteByI(@Param("thuongHieuID") int thuongHieuID);
    @Query(value = "select * from ThuongHieu p WHERE p.trangThai =0 order by p.thuongHieuID desc",nativeQuery = true)
    List<ThuongHieu> getAll();
}
