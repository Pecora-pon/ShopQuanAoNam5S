package com.example.demo.service.impl;

import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.repository.DonHangChiTietRepo;
import com.example.demo.service.DonHangChiTietService;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class DonHangChiTietServiceImpl implements DonHangChiTietService {

    @Autowired
    private DonHangChiTietRepo donHangChiTietRepo;
    @Autowired
    private SanPhamServiceImpl sanPhamService;
    @Autowired
    SizeServiceImpl sizeService;
    @Autowired
    MauSacService mauSacService;

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
        return donHangChiTietRepo.findByTrangThai(0,pageable);
    }

    @Override
    public Page<DonHangChiTiet> getPage1(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangChiTietRepo.findByTrangThai(1,pageable);
    }

    @Override
    public Page<DonHangChiTiet> getPage2(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangChiTietRepo.findByTrangThai(2,pageable);
    }

    @Override
    public Page<DonHangChiTiet> getPage3(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangChiTietRepo.findByTrangThai(3,pageable);
    }

    @Override
    public List<DonHangChiTiet> finSanPham(int id) {
        return donHangChiTietRepo.findByDonHangChiTietID(id);
    }

    @Override
    public Page<DonHangChiTiet> getPage4(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangChiTietRepo.findByTrangThai(4,pageable);
    }
    @Override
    public Page<DonHangChiTiet> getPage5(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangChiTietRepo.findByTrangThai(5,pageable);
    }
    @Override
    public Page<DonHangChiTiet> getPage6(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return donHangChiTietRepo.findByTrangThai(6,pageable);
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
    public List<DonHangChiTiet> getAllll() {
        return donHangChiTietRepo.getAllll();
    }

    @Override
    public List<DonHangChiTiet> getTC() {
        return donHangChiTietRepo.getA();
    }

    @Override
    public List<DonHangChiTiet> getAlllll() {
        return donHangChiTietRepo.getAlllll();
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
    public void chuyentrangthaicho(UUID id) {
     donHangChiTietRepo.chuyenTrangThaiCho(id);
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
    public void chuyensangchohuy(UUID id) {
     donHangChiTietRepo.chuyenTrangThaiChoHuy(id);
    }

    @Override
    public List<DonHangChiTiet> findkhachHang(String username) {
        return donHangChiTietRepo.findByDonHang_KhachHang_Username(username);
    }

    @Override
    public List<DonHangChiTiet> findkhachHang1(String username) {
        return donHangChiTietRepo.findByDonHang_KhachHang_Username1(username);
    }

    @Override
    public List<DonHangChiTiet> findkhachHang2(String username) {
        return donHangChiTietRepo.findByDonHang_KhachHang_Username2(username);
    }

    @Override
    public List<DonHangChiTiet> findkhachHang3(String username) {
        return donHangChiTietRepo.findByDonHang_KhachHang_Username3(username);
    }

    @Override
    public List<DonHangChiTiet> findkhachHang4(String username) {
        return donHangChiTietRepo.findByDonHang_KhachHang_Username4(username);
    }

    @Override
    public List<DonHangChiTiet> findkhachHang5(String username) {
        return donHangChiTietRepo.findByDonHang_KhachHang_Username5(username);
    }

    @Override
    public List<DonHangChiTiet> findkhachHang6(String username) {
        return donHangChiTietRepo.findByDonHang_KhachHang_Username6(username);
    }


    @Override
    public List<DonHangChiTiet> findNgayDat(LocalDate ngaydat) {
        return donHangChiTietRepo.findByDonHang_NgayDatHang(ngaydat);
    }

    @Override
    public List<DonHangChiTiet> findTenSP(String ten) {


        return  donHangChiTietRepo.findBySanPham_TenSanPham(ten);
    }

    @Override
    public List<DonHangChiTiet> finDonHang(UUID id) {
        return donHangChiTietRepo.findByDonHang_DonHangID(id);
    }

    @Override
    public List<DonHangChiTiet> findTongTien(Float tong) {
        return donHangChiTietRepo.findByTongTien(tong);
    }

    @Override
    public void chuyentrangthai(UUID id) {
        donHangChiTietRepo.chuyenTrangThai(id);
    }

    @Override
    public void chuyensangxn(UUID id) {
       donHangChiTietRepo.chuyensangxn(id);
       List<DonHangChiTiet>list=donHangChiTietRepo.findById(id);
       for (DonHangChiTiet dhct:list){
           dhct.setNgayNhan(LocalDate.now());
           donHangChiTietRepo.save(dhct);
       }
    }

    @Override
    public void chuyensangtc(UUID id) {
       donHangChiTietRepo.chuyensangtc(id);
    }
}
