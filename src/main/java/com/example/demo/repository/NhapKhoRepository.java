package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.NhapKho;
import com.example.demo.entity.SanPham;
import com.example.demo.entity.XuatKho;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhapKhoRepository extends JpaRepository<NhapKho,Integer> {
    Page<NhapKho> findByTrangThai(Integer tinhTrang, Pageable pageable);
    @Query("Select xk from NhapKho  xk where xk.Size.sizeID=:size")
    List<NhapKho> findBySize(Integer size);
    @Query("Select xk from NhapKho xk where xk.MauSac.mauSacID=:mauSac")
    List<NhapKho> findByMauSac(Integer mauSac);
    @Query("Select xk from NhapKho xk where xk.NhaCungCap.nhaCungCapID=:nhaCungCap")
    List<NhapKho> findByNhaCC(Integer nhaCungCap);
    @Query("Select xk from NhapKho xk where xk.ChatLieu.chatLieuID=:chatLieu")
    List<NhapKho> findByChatLieu(Integer chatLieu);
    @Query("Select xk from NhapKho xk order by xk.ngayNhap desc ")
    List<NhapKho> getAl();
    @Transactional
    @Modifying
    @Query(value = "Update NhapKho set trangThai = 1 where nhapKhoID =:nhapKhoID",nativeQuery = true)
    void deleteByI(@Param("nhapKhoID") int nhapKhoID);
    @Query(value = "select * from NhapKho p WHERE p.trangThai =0 order by p.nhapKhoID desc",nativeQuery = true)
    List<NhapKho> getAll();
}
