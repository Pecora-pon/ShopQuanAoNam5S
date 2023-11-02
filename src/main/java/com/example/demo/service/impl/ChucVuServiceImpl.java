package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepo;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepo chucVuRepo;
    @Override
    public List<ChucVu> getAll() {
        return chucVuRepo.findAll();
    }

    @Override
    public ChucVu add(ChucVu chucVu) {
        return chucVuRepo.save(chucVu);
    }

    @Override
    public ChucVu update(Integer chucVuID, ChucVu chucVu) {
        ChucVu chucVu1 = detail(chucVuID);
        if(chucVu1 !=null){
            chucVu1.setChucVuID(chucVu.getChucVuID());
            chucVu1.setTenChucVu(chucVu.getTenChucVu());
            chucVuRepo.save(chucVu);
        }
        return null;
    }

    @Override
    public void delete(Integer chucVuID) {
        chucVuRepo.deleteById(chucVuID);
    }

    @Override
    public ChucVu detail(Integer chucVuID) {
        return chucVuRepo.findById(chucVuID).orElse(null);
    }
}
