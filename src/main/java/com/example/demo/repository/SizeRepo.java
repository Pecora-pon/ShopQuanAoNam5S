package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepo extends JpaRepository<Size,Integer> {
    @Query("Select s from Size s where s.tenSize like %?1%")
    List<Size> searchBy(String keyword);
    @Query("Select s from Size s order by s.sizeID desc ")
    List<Size> getAl();
}
