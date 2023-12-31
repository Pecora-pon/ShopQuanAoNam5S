package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.NhaCungCap;
import com.example.demo.entity.SanPham;
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
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap,Integer> {
    boolean existsByTenNhaCungCap(String tenNhaCungCap);
    Page<NhaCungCap> findByTrangThai(Integer tinhTrang, Pageable pageable);
    @Query("Select n from NhaCungCap n Where n.tenNhaCungCap like :keyword or n.email like :keyword or n.diaChi like :keyword ")
    List<NhaCungCap> searchBy(@Param("keyword")String keyword);
    @Query("Select n from NhaCungCap n order by n.nhaCungCapID desc ")
    List<NhaCungCap> getAl();
    @Query("Select n from NhaCungCap n where n.tenNhaCungCap =:tenNhaCungCap and n.trangThai=0")
    NhaCungCap serchByTen(@Param("tenNhaCungCap")String tenNhaCungCap);
    @Transactional
    @Modifying
    @Query(value = "Update NhaCungCap set trangThai = 1 where nhaCungCapID =:nhaCungCapID",nativeQuery = true)
    void deleteByI(@Param("nhaCungCapID") int nhaCungCapID);
    @Query(value = "select * from NhaCungCap p WHERE p.trangThai =0 order by p.nhaCungCapID desc",nativeQuery = true)
    List<NhaCungCap> getAll();
}
