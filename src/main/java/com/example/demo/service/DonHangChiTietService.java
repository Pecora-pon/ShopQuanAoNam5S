package com.example.demo.service;

import com.example.demo.entity.DonHangChiTiet;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DonHangChiTietService {

    List<DonHangChiTiet> getAll();

    DonHangChiTiet detail(Integer donHangChiTietID);

    void add(DonHangChiTiet donHangChiTiet);

    Page<DonHangChiTiet> getPage(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage1(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage2(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage3(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage4(int pageNumber, int pageSize);
    void delete(Integer donHangChiTietID);

    List<DonHangChiTiet> findTenKhachHang(String keyword);
    void chuyentrangthai(UUID id);
    List<DonHangChiTiet>getAlll();
    List<DonHangChiTiet>getTC();
    List<DonHangChiTiet>gethuy();
    List<DonHangChiTiet>gethuyttt();
    void chuyensangxn(UUID id);
    void chuyensangtc(UUID id);
    void chuyensanghuy(UUID id);
   List<DonHangChiTiet> findkhachHang(String username);
    List<DonHangChiTiet> findkhachHang1(String username);
    List<DonHangChiTiet> findkhachHang2(String username);
    List<DonHangChiTiet> findkhachHang3(String username);
    List<DonHangChiTiet> findkhachHang4(String username);
    List<DonHangChiTiet> findNgayDat(LocalDate ngaydat);
    List<DonHangChiTiet> findTenSP(String ten);
    List<DonHangChiTiet> finDonHang(UUID id);
    List<DonHangChiTiet> findTongTien(Float tong);

}
