package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepo;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShopImpl implements ShopService {
    @Autowired
    private SanPhamRepo sanPhamRepo;
    @Override
    public Page<SanPham> getPage(int pageNumber, int pageSize) {
        List<SanPham> sanPhams = getAll();
        int start = pageNumber * pageSize;
        int end = Math.min(start + pageSize, sanPhams.size());
        List<SanPham> content = sanPhams.subList(start, end);
        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), sanPhams.size());    }

    @Override
    public List<SanPham> findByThuongHieu(String thuonghieuid) {
        return sanPhamRepo.findByThuongHieuID(thuonghieuid);
    }


    @Override
    public List<SanPham> findByMauSacID(String mauSacID) {
        return sanPhamRepo.findByMauSacID(mauSacID);
    }

    @Override
    public List<SanPham> findByChatLieuID(String chatLieuID) {
        return sanPhamRepo.findByChatLieuID(chatLieuID);
    }

    @Override
    public List<SanPham> findBySizeID(String sizeID) {
        return sanPhamRepo.findBySizeID(sizeID);
    }

    @Override
    public List<SanPham> findByTenSanPham(String tenSanPham) {
        return sanPhamRepo.findByTenSanPham(tenSanPham);
    }

    @Override
    public List<SanPham> findByHinhAnhURL(String hinhAnhURL) {
        return sanPhamRepo.findByHinhAnhURL(hinhAnhURL);
    }

    @Override
    public List<SanPham> findByProductInPriceRange(Double minPrice, Double maxPrice) {
        return sanPhamRepo.findProductsInPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<SanPham> getAll() {
       return sanPhamRepo.findAll();
    }

    @Override
    public SanPham detail(UUID sanPhamID) {
        return sanPhamRepo.findById(sanPhamID).orElse(null);
    }

    @Override
    public SanPham themgio(UUID sanPhamID) {
        return sanPhamRepo.getById(sanPhamID);
    }

//    @Override
//    public List<SanPham> findBySize(String tenSize) {
//        return sanPhamRepo.findBySize(tenSize);
//    }
}
