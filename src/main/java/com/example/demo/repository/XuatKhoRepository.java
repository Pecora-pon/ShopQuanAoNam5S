package com.example.demo.repository;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.XuatKho;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Transactional
    @Modifying
    @Query(value = "Update XuatKho set trangThai = 1 where xuatKhoID =:xuatKhoID",nativeQuery = true)
    void deleteByI(@Param("xuatKhoID") int xuatKhoID);
    @Query(value = "select * from XuatKho p WHERE p.trangThai =0 order by p.xuatKhoID desc",nativeQuery = true)
    List<XuatKho> getAll();
}
