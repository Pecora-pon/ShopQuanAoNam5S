package com.example.demo.service;

import com.example.demo.entity.ChucVu;

import java.util.List;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu add(ChucVu chucVu);

    ChucVu update(Integer chucVuID, ChucVu chucVu);

    void delete(Integer chucVuID);

    ChucVu detail(Integer chucVuID);
}
