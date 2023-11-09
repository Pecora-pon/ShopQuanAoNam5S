package com.example.demo.service;

import com.example.demo.entity.DonHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface DonHangService {

    List<DonHang> getAll();

    DonHang detail(UUID donHangID);

    void add(DonHang donHang);

    Page<DonHang> getPage(int pageNumber, int pageSize);

    void delete(UUID donHangID);

    List<DonHang> findTenKhachHang(String keyword);

}
