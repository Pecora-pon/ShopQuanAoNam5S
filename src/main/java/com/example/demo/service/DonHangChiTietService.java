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

    double delete1(int id);

    Page<DonHangChiTiet> getPage(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage1(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage2(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage3(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage4(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage5(int pageNumber, int pageSize);
    Page<DonHangChiTiet> getPage6(int pageNumber, int pageSize);
    void delete(Integer donHangChiTietID);

    List<DonHangChiTiet> findTenKhachHang(String keyword);
    void chuyentrangthai(UUID id);
    List<DonHangChiTiet>getAlll();
    List<DonHangChiTiet>getAllll();
    List<DonHangChiTiet>getTC();
    List<DonHangChiTiet>getAlllll();
    List<DonHangChiTiet>gethuy();
    List<DonHangChiTiet>gethuyttt();
    List<DonHangChiTiet>vi(String name);
    void chuyentrangthaicho(UUID id);
    void chuyentrangthaicho1(UUID id);
    void chuyensangxn(UUID id);
    void chuyensangtc(UUID id);
    void chuyensanghuy(UUID id);
    void chuyensanghuy1(UUID id);
    List<DonHangChiTiet> chuyensangchohuy(List<UUID> id,String lydo);
   List<DonHangChiTiet> findkhachHang(String username);
    List<DonHangChiTiet> findkhachHang1(String username);
    List<DonHangChiTiet> findkhachHang2(String username);
    List<DonHangChiTiet> findkhachHang3(String username);
    List<DonHangChiTiet> findkhachHang4(String username);
    List<DonHangChiTiet> findkhachHang5(String username);
    List<DonHangChiTiet> findkhachHang6(String username);

    List<DonHangChiTiet> findTenSP(String ten,int trang);
    List<DonHangChiTiet> findTenSP1(String ten,int trang);
    List<DonHangChiTiet> findTenSP2(String ten,int trang);
    List<DonHangChiTiet> findTenSP3(String ten,int trang);
    List<DonHangChiTiet> findTenSP4(String ten,int trang);
    List<DonHangChiTiet> findTenSP5(String ten,int trang);
    List<DonHangChiTiet> findTenSP6(String ten,int trang);

    List<DonHangChiTiet> finDonHang(UUID id);
    List<DonHangChiTiet> finSanPham(int id);
    List<DonHangChiTiet> findTongTien6(Float tong,int trang);
    List<DonHangChiTiet> findTongTien2(Float tong,int trang);
    List<DonHangChiTiet> findTongTien3(Float tong,int trang);
    List<DonHangChiTiet> findTongTien4(Float tong,int trang);
    List<DonHangChiTiet> findTongTien5(Float tong,int trang);
    List<DonHangChiTiet> findTongTien1(Float tong,int trang);
    List<DonHangChiTiet> findTongTien(Float tong,int trang);

    List<DonHangChiTiet> findNgayDat(LocalDate ngaydat,int trang);
    List<DonHangChiTiet> findNgayDat1(LocalDate ngaydat,int trang);
    List<DonHangChiTiet> findNgayDat2(LocalDate ngaydat,int trang);
    List<DonHangChiTiet> findNgayDat3(LocalDate ngaydat,int trang);
    List<DonHangChiTiet> findNgayDat4(LocalDate ngaydat,int trang);
    List<DonHangChiTiet> findNgayDat5(LocalDate ngaydat,int trang);
    List<DonHangChiTiet> findNgayDat6(LocalDate ngaydat,int trang);

}
