package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepo khachHangRepo;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepo.findAll();
    }

    @Override
    public KhachHang detail(Integer khachHangId) {
        return khachHangRepo.findById(khachHangId).get();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepo.save(khachHang);
    }

    @Override
    public Page<KhachHang> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return khachHangRepo.findAll(pageable);
    }

    @Override
    public void delete(Integer khachHangId) {
        khachHangRepo.deleteById(khachHangId);
    }

    @Override
    public List<KhachHang> findTenOrDiaChi(String keyword) {
        return null;
    }


}
