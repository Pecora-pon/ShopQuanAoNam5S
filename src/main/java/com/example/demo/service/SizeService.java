package com.example.demo.service;


import com.example.demo.entity.Size;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SizeService {
    List<Size> getAll();

   Respon<Size> add(Size size);

   Respon<Size>  update(Integer sizeID, Size size);

    void delete(Integer sizeID);

    Size detail(Integer sizeID);

    List<Size> findSize(String keyword);
    Page<Size> getPage(int pageNumber,int pageSize);


}
