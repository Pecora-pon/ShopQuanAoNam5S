package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.Size;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.SizeRepo;
import com.example.demo.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeServiceImpl implements SizeService {
  @Autowired
    SizeRepo sizeRepo;

    @Override
    public List<Size> getAll() {
        return sizeRepo.getAl();
    }

    @Override
    public Respon<Size> add(Size size) {
        Respon<Size> respon=new Respon<>();
        String tenSize=size.getTenSize().trim();
        if(size.getTenSize() != null && !size.getTenSize().isEmpty()){
            size.setTenSize(tenSize);
            sizeRepo.save(size);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Tên không đúng");
        }
        return respon;
    }

    @Override
    public Respon<Size> update(Integer sizeID, Size size) {
        Respon<Size>respon=new Respon<>();
        Size size1=detail(sizeID);
        if(size1 != null){
            size1.setSizeID(size.getSizeID());
            size1.setTenSize(size.getTenSize());
            sizeRepo.save(size);
            respon.setStatus("thành công");
        }else {
            respon.setError("Không thành công");
        }
        return null;
    }

    @Override
    public void delete(Integer sizeID) {
sizeRepo.deleteById(sizeID);
    }

    @Override
    public Size detail(Integer sizeID) {
        return sizeRepo.findById(sizeID).orElse(null);
    }

    @Override
    public List<Size> findSize(String keyword) {
        return sizeRepo.searchBy(keyword);
    }

    @Override
    public Page<Size> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return sizeRepo.findAll(pageable);
    }
}
