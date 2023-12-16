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
        return mauSacRepo.getAlll();
    }

    @Override
    public Respon<MauSac> add(MauSac mauSac) {
        Respon<MauSac> respon = new Respon<>();
        String tenMauSac = mauSac.getTenMauSac().trim();

        if (tenMauSac != null && !tenMauSac.isEmpty()) {
            // Check if the name contains only spaces
            if (!isOnlySpaces(tenMauSac)) {
                if (mauSacRepo.existsByTenMauSac(tenMauSac)) {
                    respon.setError("Tên Màu Sắc đã tồn tại. Vui lòng chọn tên khác");
                } else {
                    mauSac.setTenMauSac(tenMauSac);
                    mauSac.setTrangThai(0);
                    mauSacRepo.save(mauSac);
                    respon.setStatus("Thành công");
                }
            } else {
                respon.setError("Tên đang bị sai");
            }
        } else {
            respon.setError("Tên không được để trống");
        }

        return respon;
    }

    private boolean isOnlySpaces(String input) {
        // Check if the input contains only spaces
        return input.matches("^\\s*$");
    }
    @Override
    public Respon<MauSac> update(Integer mauSacID, MauSac mauSac) {
        Respon<MauSac>respon=new Respon<>();
        MauSac mauSac1=detail(mauSacID);
        if(mauSac1!=null){
            if(!isOnlySpaces(mauSac.getTenMauSac())) {
                mauSac1.setMauSacID(mauSac.getMauSacID());
                mauSac1.setTenMauSac(mauSac.getTenMauSac());
                mauSacRepo.save(mauSac1);
                respon.setStatus("Thành công");
            }else {
                respon.setError("Không đúng định dạng");
            }
        }else {
            respon.setError("Không thành cong");
        }
        return respon;
    }

    @Override
    public void delete(Integer mauSacID) {
     mauSacRepo.deleteByI(mauSacID);
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
        return mauSacRepo.findByTrangThai(0,pageable);
    }
}
