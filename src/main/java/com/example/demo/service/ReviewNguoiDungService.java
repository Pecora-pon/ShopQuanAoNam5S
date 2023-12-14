package com.example.demo.service;

import com.example.demo.entity.ReviewNguoiDung;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ReviewNguoiDungService {

    List<ReviewNguoiDung> getAll();

    ReviewNguoiDung add(ReviewNguoiDung reviewNguoiDung);

    ReviewNguoiDung update(Integer reviewID, ReviewNguoiDung reviewNguoiDung);

    void delete(Integer reviewID);

   List<ReviewNguoiDung> findBy(UUID id);

    ReviewNguoiDung detail(Integer reviewID);

    Page<ReviewNguoiDung> getPage(int pageNumber, int pageSize);

    List<ReviewNguoiDung> findTenkhachHang(String keyword);
}
