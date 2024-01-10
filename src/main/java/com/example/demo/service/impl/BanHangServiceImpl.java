package com.example.demo.service.impl;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.DonHangChiTietRepo;
import com.example.demo.repository.DonHangRepo;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.BanHangService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BanHangServiceImpl implements BanHangService {
@Autowired
    DonHangRepo donHangRepo;
@Autowired
    DonHangChiTietRepo donHangChiTietRepo;
@Autowired
    SanPhamRepo sanPhamRepo;
@Autowired
    SanPhamService sanPhamService;

    @Override
    public DonHangChiTiet insert(DonHang donHang, DonHangChiTiet donHangChiTiet) {
    DonHang dh=donHangRepo.save(donHang);
    DonHangChiTiet dhct=new DonHangChiTiet();
    dhct.setDonHang(dh);
    dhct.setTrangThai(8);
    donHangChiTietRepo.save(dhct);
        return dhct;
    }
    private String lastUsedNumber = "0";

    @Override
    public void insertdh(DonHang donHang) {
        donHang.setTrangThai(1);
        donHang.setHinhThucThanhToan("3");
        donHang.setNgayDatHang(LocalDate.now());
        String generatedName = generateIncrementalName();
        donHang.setTenKhach(generatedName);
        donHangRepo.save(donHang);
    }
    private String generateIncrementalName() {
        // Convert the last used number to an integer, increment it, and convert it back to a String
        int incrementedNumber = Integer.parseInt(lastUsedNumber) + 1;
        lastUsedNumber = String.valueOf(incrementedNumber);

        // Generate the name in the format "HD" followed by the incremented number
        return "HD" + lastUsedNumber;
    }
    @Override
    public List<DonHangChiTiet> getAll(UUID id) {
        return donHangChiTietRepo.banHang(id);
    }

    @Override
    public DonHangChiTiet insertsp(UUID sanPham, UUID donHang) {
        // Retrieve the product and order
        SanPham sp = sanPhamRepo.findById(sanPham).orElse(null);
        DonHang dh = donHangRepo.findById(donHang).orElse(null);

        // Check if the product is already in the order details
        DonHangChiTiet existingDhct = donHangChiTietRepo.findBySanPhamAndDonHang(sp, dh);

        if (existingDhct != null) {
            // If the product is already in the order details, update the quantity
            existingDhct.setSoLuong(existingDhct.getSoLuong() + 1);
            // You may want to update other properties if needed
            existingDhct.setTrangThai(8); // Assuming you always set the status to 8
            return donHangChiTietRepo.save(existingDhct);
        } else {
            // If the product is not in the order details, create a new entry
            DonHangChiTiet newDhct = new DonHangChiTiet();
            newDhct.setSanPham(sp);
            newDhct.setDonHang(dh);
            newDhct.setSoLuong(1);
            newDhct.setTrangThai(8); // Assuming you always set the status to 8
            return donHangChiTietRepo.save(newDhct);
        }
    }

    @Override
    public SanPham detail(UUID id) {
        return sanPhamRepo.findById(id).orElse(null);
    }

    @Override
    public List<DonHang> getAlll() {
        return donHangRepo.ban();
    }

    @Override
    public List<DonHangChiTiet> banhang(List<Integer> donhang,float tong) {
       List<DonHangChiTiet>list=donHangChiTietRepo.findAllByDonHangChiTietIDInAndTrangThai(donhang,8);
       for(DonHangChiTiet donHangChiTiet:list){
           donHangChiTiet.setNgayNhan(LocalDate.now());
           donHangChiTiet.setTrangThai(3);
           donHangChiTiet.getDonHang().setTrangThai(2);
           UUID sp=donHangChiTiet.getSanPham().getSanPhamID();
          int sl= donHangChiTiet.getSoLuong();
          float gia=donHangChiTiet.getSanPham().getGiaSanPham();
           donHangChiTiet.setTongTien(tong);
           sanPhamService.capnhat(sp,sl);
       }
       donHangChiTietRepo.saveAll(list);
       return list;
    }

    @Override
    public void delete(int id) {
        donHangChiTietRepo.deleteById(id);
    }

    @Override
    public void delete1(UUID id) {
        donHangRepo.deleteById(id);
    }

    @Override
    public List<SanPham> findbyten(String ten) {
        return sanPhamRepo.findByTenSanPhamOrSize_TenSizeOrMauSac_TenMauSac(ten);
    }

}
