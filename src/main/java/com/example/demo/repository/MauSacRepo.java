package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac,Integer> {
    @Query("select m from MauSac m where m.tenMauSac like %?1%")
    List<MauSac> searchByten(String keyword);
    @Query("select m from MauSac m order by m.mauSacID desc ")
    List<MauSac> getAl();
}
