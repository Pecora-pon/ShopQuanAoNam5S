package com.example.demo.service.impl;

import com.example.demo.entity.DonHang;
import com.example.demo.repository.DonHangRepo;
import com.example.demo.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DonHangServiceImpl implements DonHangService {

    @Autowired
    private DonHangRepo donHangRepo;

    @Override
    public List<DonHang> getAll() {
        return donHangRepo.findAll();
    }

    @Override
    public DonHang detail(UUID donHangID) {
        return donHangRepo.findById(donHangID).get();
    }

    @Override
    public void add(DonHang donHang) {
        donHangRepo.save(donHang);
    }

    @Override
    public Page<DonHang> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangRepo.findAll(pageable);
    }

    @Override
    public void delete(UUID donHangID) {
        donHangRepo.deleteById(donHangID);
    }

    @Override
    public List<DonHang> findTenKhachHang(String keyword) {
        return donHangRepo.searchByTenKhach(keyword);
    }
}
