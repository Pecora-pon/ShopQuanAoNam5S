package com.example.demo.service;

import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShopService {
    Page<SanPham> getPage(int pageNumber,int pageSize);

    List<SanPham> findByThuongHieu(String thuonghieuid);

    List<SanPham> getAll();


}
