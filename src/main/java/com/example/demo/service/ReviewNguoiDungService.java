package com.example.demo.service;

import com.example.demo.entity.ReviewNguoiDung;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReviewNguoiDungService {

    List<ReviewNguoiDung> getAll();

    ReviewNguoiDung add(ReviewNguoiDung reviewNguoiDung);

    ReviewNguoiDung update(Integer reviewID, ReviewNguoiDung reviewNguoiDung);

    void delete(Integer reviewID);

    ReviewNguoiDung detail(Integer reviewID);

    Page<ReviewNguoiDung> getPage(int pageNumber, int pageSize);

    List<ReviewNguoiDung> findTenkhachHang(String keyword);
}
