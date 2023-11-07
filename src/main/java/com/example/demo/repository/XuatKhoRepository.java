package com.example.demo.repository;

import com.example.demo.entity.XuatKho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface XuatKhoRepository extends JpaRepository<XuatKho,Integer> {
@Query("Select xk from XuatKho xk where xk.Size.sizeID=:size")
    List<XuatKho> findBySize(Integer size);
    @Query("Select xk from XuatKho xk where xk.MauSac.mauSacID=:mauSac")
    List<XuatKho> findByMauSac(Integer mauSac);
    @Query("Select xk from XuatKho xk where xk.NhaCungCap.nhaCungCapID=:nhaCungCap")
    List<XuatKho> findByNhaCC(Integer nhaCungCap);
    @Query("Select xk from XuatKho xk where xk.ChatLieu.chatLieuID=:chatLieu")
    List<XuatKho> findByChatLieu(Integer chatLieu);
    @Query("Select xk from XuatKho xk order by xk.ngayXuat desc")
    List<XuatKho> getAl();
}
