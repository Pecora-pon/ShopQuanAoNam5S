package com.example.demo.service;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface DonHangChiTietService {

    List<DonHangChiTiet> getAll();

    DonHangChiTiet detail(Integer donHangChiTietID);

    void add(DonHangChiTiet donHangChiTiet);

    Page<DonHangChiTiet> getPage(int pageNumber, int pageSize);

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


}
