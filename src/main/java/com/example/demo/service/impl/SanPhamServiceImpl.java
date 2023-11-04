package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepo repo;

    @Override
    public List<SanPham> getAll() {
        return repo.findAll();
    }

    @Override
    public SanPham add(SanPham sanPham) {
        return null;
    }

    @Override
    public SanPham update(UUID sanPhamID, SanPham sanPham) {
        return null;
    }

    @Override
    public void delete(UUID sanPhamID) {

    }

    @Override
    public SanPham detail(UUID sanPhamID) {
        return null;
    }

    @Override
    public Optional<SanPham> findByID(UUID sanPhamID) {
        return Optional.empty();
    }
}
