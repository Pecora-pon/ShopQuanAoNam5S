package com.example.demo.service.impl;

import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.repository.DonHangChiTietRepo;
import com.example.demo.service.DonHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangChiTietServiceImpl implements DonHangChiTietService {

    @Autowired
    private DonHangChiTietRepo donHangChiTietRepo;

    @Override
    public List<DonHangChiTiet> getAll() {
        return donHangChiTietRepo.findAll();
    }

    @Override
    public DonHangChiTiet detail(Integer donHangChiTietID) {
        return donHangChiTietRepo.findById(donHangChiTietID).get();
    }

    @Override
    public void add(DonHangChiTiet donHangChiTiet) {
        donHangChiTietRepo.save(donHangChiTiet);
    }

    @Override
    public Page<DonHangChiTiet> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangChiTietRepo.findAll(pageable);
    }

    @Override
    public void delete(Integer donHangChiTietID) {
        donHangChiTietRepo.deleteById(donHangChiTietID);
    }

    @Override
    public List<DonHangChiTiet> findTenKhachHang(String keyword) {
        return null;
    }
}
