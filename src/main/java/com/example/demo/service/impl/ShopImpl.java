package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopImpl implements ShopService {
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @Override
    public Page<SanPham> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return sanPhamRepo.findAll(pageable);
    }

    @Override
    public List<SanPham> findByThuongHieu(String thuonghieuid) {
        return sanPhamRepo.findByThuongHieuID(thuonghieuid);
    }

    @Override
    public List<SanPham> getAll() {
       return sanPhamRepo.findAll();
    }
}
