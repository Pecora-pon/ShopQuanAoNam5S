package com.example.demo.service;

import com.example.demo.entity.KhachHang;

import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang detail(Integer khachHangId);

    void add(KhachHang khachHang);

    Page<KhachHang> getPage(int pageNumber, int pageSize);

    void delete(Integer khachHangId);

    List<KhachHang> findTenOrDiaChi(String keyword);


}
