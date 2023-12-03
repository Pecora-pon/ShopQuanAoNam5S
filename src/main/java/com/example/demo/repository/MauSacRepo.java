package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.MauSac;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac,Integer> {
    @Query("select m from MauSac m where m.tenMauSac like %?1%")
    List<MauSac> searchByten(String keyword);
    @Query("select m from MauSac m where m.tenMauSac =:tenMauSac")
    MauSac searchBytenms(@Param("tenMauSac") String tenMauSac);
    @Query("select m from MauSac m order by m.mauSacID desc ")
    List<MauSac> getAl();
    @Transactional
    @Modifying
    @Query(value = "Update MauSac set trangThai = 1 where mauSacID =:mauSacID",nativeQuery = true)
    void deleteByI(@Param("mauSacID") int mauSacID);
    @Query(value = "select * from MauSac p WHERE p.trangThai =0 order by p.mauSacID desc",nativeQuery = true)
    List<ChatLieu> getAlll();
}
