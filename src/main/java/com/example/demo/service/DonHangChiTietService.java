package com.example.demo.service;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface DonHangChiTietService {

    List<DonHangChiTiet> getAll();

    DonHangChiTiet detail(Integer donHangChiTietID);

    void add(DonHangChiTiet donHangChiTiet);

    Page<DonHangChiTiet> getPage(int pageNumber, int pageSize);

    void delete(Integer donHangChiTietID);

    List<DonHangChiTiet> findTenKhachHang(String keyword);

}
