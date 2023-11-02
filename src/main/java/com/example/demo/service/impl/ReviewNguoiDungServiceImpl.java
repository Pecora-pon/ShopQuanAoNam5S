package com.example.demo.service.impl;


import com.example.demo.entity.ReviewNguoiDung;
import com.example.demo.repository.ReviewNguoiDungRepo;
import com.example.demo.service.ReviewNguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewNguoiDungServiceImpl implements ReviewNguoiDungService {

    @Autowired
    private ReviewNguoiDungRepo repo;


    @Override
    public List<ReviewNguoiDung> getAll() {
        return repo.findAll();
    }

    @Override
    public ReviewNguoiDung add(ReviewNguoiDung reviewNguoiDung) {
        return repo.save(reviewNguoiDung);
    }

    @Override
    public ReviewNguoiDung update(Integer reviewID, ReviewNguoiDung reviewNguoiDung) {
        return null;
    }

    @Override
    public void delete(Integer reviewID) {
        repo.deleteById(reviewID);
    }

    @Override
    public ReviewNguoiDung detail(Integer reviewID) {
        return repo.findById(reviewID).get();
    }

    @Override
    public Page<ReviewNguoiDung> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return repo.findAll(pageable);
    }

    @Override
    public List<ReviewNguoiDung> findTenkhachHang(String keyword) {
        return null;
    }

//    public List<ReviewNguoiDung> findTenkhachHang(String keyword) {
//        return repo.searchByKhachHang(keyword);
//    }
}
