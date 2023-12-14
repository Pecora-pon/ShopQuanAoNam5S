package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepo.getAll();
    }

    @Override
    public Respon<SanPham> add(SanPham sanPham) {
        Respon<SanPham> respon = new Respon<>();

        // Kiểm tra giá sản phẩm phải khác null và là số
        if (sanPham.getGiaSanPham() != null &&
                isNumeric1(String.valueOf(sanPham.getGiaSanPham())) &&

                // Kiểm tra tất cả các trường bắt buộc không được để trống
                sanPham.getTenSanPham() != null && !sanPham.getTenSanPham().isEmpty() &&
                sanPham.getMoTa() != null && !sanPham.getMoTa().isEmpty() &&
                sanPham.getSize() != null &&
                sanPham.getChatLieu() != null &&
                sanPham.getMauSac() != null &&
                sanPham.getThuongHieu() != null &&
                sanPham.getHinhAnhURL() != null &&
                // Kiểm tra số lượng tồn phải khác null và là số
                sanPham.getSoLuongTon() != null && isNumeric(String.valueOf(sanPham.getSoLuongTon()))) {
           if(sanPhamRepo.existsByTenSanPham(sanPham.getTenSanPham())){
               respon.setError("Tên sản phẩm đã tồn tại. Vui lòng chọn tên khác.");
           }else {
               sanPham.setNgayTao(LocalDate.now());
               sanPhamRepo.save(sanPham);
               respon.setStatus("Thành công");
           }
        } else {
            respon.setError("Không được để trống các trường bắt buộc, và giá sản phẩm phải là số");
        }

        return respon;
    }

    // Phương thức kiểm tra xem một chuỗi có phải là số không
    private boolean isNumeric1(String str) {
        try {
            Double.parseDouble(str); // Sử dụng Double để hỗ trợ số thập phân
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Phương thức kiểm tra xem một chuỗi có phải là số nguyên không
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @Override
    public Respon<SanPham> update(UUID sanPhamID, SanPham sanPham) {
        Respon<SanPham> respon = new Respon<>();
        SanPham sanPham1 = detail(sanPhamID);
        if (sanPham1 != null) {
            sanPham1.setGiaSanPham(sanPham.getGiaSanPham());
            sanPham1.setSanPhamID(sanPham.getSanPhamID());
            sanPham1.setMauSac(sanPham.getMauSac());
            sanPham1.setTenSanPham(sanPham.getTenSanPham());
            sanPham1.setChatLieu(sanPham.getChatLieu());
            sanPham1.setSize(sanPham.getSize());
            sanPham1.setMoTa(sanPham.getMoTa());
            sanPham1.setThuongHieu(sanPham.getThuongHieu());
            sanPham1.setNgayTao(sanPham.getNgayTao());
            sanPham1.setSoLuongTon(sanPham.getSoLuongTon());
            sanPham1.setTinhTrang(sanPham.getTinhTrang());
            sanPham1.setHinhAnhURL(sanPham.getHinhAnhURL());
            sanPhamRepo.save(sanPham1);
            respon.setStatus("Thành công");
        } else {
            respon.setError("Không thành công");
        }
        return respon;
    }

    @Override
    public void delete(UUID sanPhamID) {
        sanPhamRepo.deleteByI(sanPhamID);
    }

    @Override
    public SanPham detail(UUID sanPhamID) {
        return sanPhamRepo.findById(sanPhamID).orElse(null);
    }

    @Override
    public Page<SanPham> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return sanPhamRepo.findByTinhTrang(0,pageable);
    }

    @Override
    public void capnhat(UUID id, int soluong) {
        SanPham sanPham = sanPhamRepo.findById(id).orElse(null);

        if (sanPham != null) {
            int soluongmoi = sanPham.getSoLuongTon() - soluong;
            if (soluongmoi >= 0) {
                sanPham.setSoLuongTon(soluongmoi);
                sanPhamRepo.save(sanPham);
            } else {
                throw new IllegalArgumentException("Số lượng trong sản phẩm không đủ");
            }
        }
    }

    @Override
    public SanPham size(SanPham sanPham, UUID sanPhamID) {
        SanPham sanPham1 = detail(sanPhamID);
        sanPham1.setSize(sanPham.getSize());
        sanPham1.setMauSac(sanPham.getMauSac());
        return sanPhamRepo.save(sanPham1);
    }

    @Override
    public List<SanPham> findtenSanPham(String ten) {
        return sanPhamRepo.findByTenSanPham1(ten);
    }


    @Override
    public List<SanPham> findByMauSacID(int mauSacID) {
        return sanPhamRepo.findByMauSac_MauSacID(mauSacID);
    }

    @Override
    public List<SanPham> findBySizeID(int sizeID) {
        return sanPhamRepo.findBySize_SizeID(sizeID);
    }

    @Override
    public List<SanPham> findByChatLieuID(int chatLieuID) {
        return sanPhamRepo.findByChatLieu_ChatLieuID(chatLieuID);
    }

    @Override
    public List<SanPham> findByThuongHieuID(int thuongHieuID) {
        return sanPhamRepo.findByThuongHieu_ThuongHieuID(thuongHieuID);
    }

    @Override
    public List<SanPham> getTop4SanPhamByGiaThapNhat() {
        return sanPhamRepo.findTop4ByOrderByGiaSanPhamAsc();
    }
}
