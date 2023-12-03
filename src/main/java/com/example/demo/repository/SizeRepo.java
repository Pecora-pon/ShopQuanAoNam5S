package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.Size;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepo extends JpaRepository<Size,Integer> {
    @Query("Select s from Size s where s.tenSize like %?1%")
    List<Size> searchBy(String keyword);
    @Query("Select s from Size s where s.tenSize =:tenSize and s.trangThai=0")
    Size searchByten(@Param("tenSize") String tenSize);
    @Query("Select s from Size s order by s.sizeID desc ")
    List<Size> getAl();
    @Transactional
    @Modifying
    @Query(value = "Update Size set trangThai = 1 where sizeID =:sizeID",nativeQuery = true)
    void deleteByI(@Param("sizeID") int chatLieuID);
    @Query(value = "select * from Size p WHERE p.trangThai =0 order by p.sizeID desc",nativeQuery = true)
    List<Size> getAll();
}
