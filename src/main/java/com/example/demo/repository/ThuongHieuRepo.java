package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuongHieuRepo extends JpaRepository<ThuongHieu,Integer> {
    @Query("Select th from ThuongHieu th where th.tenThuongHieu like %?1%")
    List<ThuongHieu> searchBy(String keyword);
    @Query("Select th from ThuongHieu th order by th.thuongHieuID desc ")
    List<ThuongHieu> getAl();
}
