package com.example.demo.service.impl;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.ThuongHieuRepo;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
@Autowired
    ThuongHieuRepo thuongHieuRepo;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepo.getAll();
    }

    @Override
    public Respon<ThuongHieu> add(ThuongHieu thuongHieu) {
        Respon<ThuongHieu> respon = new Respon<>();
        String tenThuongHieu = thuongHieu.getTenThuongHieu().trim();

        if (tenThuongHieu != null && !tenThuongHieu.isEmpty()) {
            // Check if the name contains only spaces
            if (!isOnlySpaces(tenThuongHieu)) {
                if (thuongHieuRepo.existsByTenThuongHieu(tenThuongHieu)) {
                    respon.setError("Tên đã tồn tại");
                } else {
                    if (!isNumeric(thuongHieu.getTenThuongHieu())) {
                        thuongHieu.setTenThuongHieu(tenThuongHieu);
                        thuongHieu.setTrangThai(0);
                        thuongHieuRepo.save(thuongHieu);
                        respon.setStatus("Thành công");
                    }else {
                        respon.setError("Tên không được chưa số");
                    }
                }
            } else {
                respon.setError("Tên không được chỉ chứa nguyên cách");
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
    private boolean isNumeric(String input) {
        // Check if the input contains only numeric characters
        return input.matches("^[0-9]+$");
    }
    @Override
    public Respon<ThuongHieu> update(Integer thuongHieuID, ThuongHieu thuongHieu) {
        Respon<ThuongHieu>respon=new Respon<>();
        ThuongHieu thuongHieu1=detail(thuongHieuID);
        if(thuongHieu1 !=null){
            if(!isOnlySpaces(thuongHieu.getTenThuongHieu())) {
                if (!isNumeric(thuongHieu.getTenThuongHieu())) {
                    thuongHieu1.setThuongHieuID(thuongHieu.getThuongHieuID());
                    thuongHieu1.setTenThuongHieu(thuongHieu.getTenThuongHieu());
                    thuongHieuRepo.save(thuongHieu);
                    respon.setStatus("Thành công");
                }else {
                    respon.setError("Tên ko được nhập số");
                }
            }else {
                respon.setError("Không đúng đinh dạng");
            }
        }else {
            respon.setError("Không thành công");
        }
        return respon;
    }

    @Override
    public void delete(Integer thuongHieuID) {
    thuongHieuRepo.deleteByI(thuongHieuID);
    }

    @Override
    public ThuongHieu detail(Integer thuongHieuID) {
        return thuongHieuRepo.findById(thuongHieuID).orElse(null);
    }

    @Override
    public List<ThuongHieu> findTen(String keyword) {
        return thuongHieuRepo.searchBy(keyword);
    }

    @Override
    public Page<ThuongHieu> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return thuongHieuRepo.findByTrangThai(0,pageable);
    }
}
