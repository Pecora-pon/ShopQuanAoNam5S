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
import java.util.UUID;

@Service
public class DonHangChiTietServiceImpl implements DonHangChiTietService {

    @Autowired
    private DonHangChiTietRepo donHangChiTietRepo;
    @Autowired
    private SanPhamServiceImpl sanPhamService;

    @Override
    public List<DonHangChiTiet> getAll() {
        return donHangChiTietRepo.getAlll();
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



    @Override
    public List<DonHangChiTiet> getAlll() {
        return donHangChiTietRepo.getAll();
    }

    @Override
    public List<DonHangChiTiet> getTC() {
        return donHangChiTietRepo.getA();
    }

    @Override
    public List<DonHangChiTiet> gethuy() {
        return donHangChiTietRepo.getHuy();
    }


    @Override
    public List<DonHangChiTiet> gethuyttt() {
        return donHangChiTietRepo.getHuyy();
    }

    @Override
    public void chuyensanghuy(UUID id) {
      donHangChiTietRepo.chuyensanghuy(id);
      List<DonHangChiTiet> list =donHangChiTietRepo.findById(id);
      for(DonHangChiTiet dhct:list) {
          int sl = dhct.getSoLuong();
          UUID sp = dhct.getSanPham().getSanPhamID();
          sanPhamService.capnhat(sp, -sl);
      }
    }

    @Override
    public void chuyentrangthai(UUID id) {
        donHangChiTietRepo.chuyenTrangThai(id);
    }

    @Override
    public void chuyensangxn(UUID id) {
       donHangChiTietRepo.chuyensangxn(id);
    }

    @Override
    public void chuyensangtc(UUID id) {
       donHangChiTietRepo.chuyensangtc(id);
    }
}
