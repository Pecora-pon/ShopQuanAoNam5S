package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.MauSacRepo;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MauSacServiceImpl implements MauSacService {
   @Autowired
    MauSacRepo mauSacRepo;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepo.getAl();
    }

    @Override
    public Respon<MauSac> add(MauSac mauSac) {
        Respon<MauSac> respon=new Respon<>();
        String tenMauSac= mauSac.getTenMauSac().trim();

        if(tenMauSac!=null){
            if (mauSac.getTenMauSac() != null && !mauSac.getTenMauSac().isEmpty()) {
                mauSac.setTenMauSac(tenMauSac);
                mauSac.setTrangThai(0);
                mauSacRepo.save(mauSac);
                respon.setStatus("Thành công");
            } else {
                respon.setError("Tên đang bị sai");
            }
        }
        return respon;
    }

    @Override
    public Respon<MauSac> update(Integer mauSacID, MauSac mauSac) {
        Respon<MauSac>respon=new Respon<>();
        MauSac mauSac1=detail(mauSacID);
        if(mauSac1!=null){
            mauSac1.setMauSacID(mauSac.getMauSacID());
            mauSac1.setTenMauSac(mauSac.getTenMauSac());
            mauSacRepo.save(mauSac);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Không thành cong");
        }
        return respon;
    }

    @Override
    public void delete(Integer mauSacID) {
     mauSacRepo.deleteById(mauSacID);
    }

    @Override
    public MauSac detail(Integer mauSacID) {
        return mauSacRepo.findById(mauSacID).orElse(null);
    }

    @Override
    public List<MauSac> findTen(String keyword) {
        return mauSacRepo.searchByten(keyword);
    }

    @Override
    public Page<MauSac> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return mauSacRepo.findAll(pageable);
    }
}
