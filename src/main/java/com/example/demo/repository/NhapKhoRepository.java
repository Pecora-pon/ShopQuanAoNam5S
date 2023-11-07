package com.example.demo.repository;

import com.example.demo.entity.NhapKho;
import com.example.demo.entity.XuatKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhapKhoRepository extends JpaRepository<NhapKho,Integer> {
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
}
