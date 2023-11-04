package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepo extends JpaRepository<Size,Integer> {
}
