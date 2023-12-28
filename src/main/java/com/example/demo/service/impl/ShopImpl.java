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
    public Page<SanPham> getPages(int page, int size, String thuonghieuID,String sizeID,String tenSanPham) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepo.getPages(sizeID,thuonghieuID,tenSanPham,pageable);
    }


    @Override
    public Page<SanPham> findByMauSacID(int page, int size,String mauSacID) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepo.findByMauSacID(mauSacID,pageable);
    }

    @Override
    public Page<SanPham> findByChatLieuID(int page, int size,String chatLieuID) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepo.findByChatLieuID(chatLieuID,pageable);
    }

    @Override
    public Page<SanPham> findBySizeID(int page, int size,String sizeID) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepo.findBySizeID(sizeID,pageable);
    }

    @Override
    public Page<SanPham>findByTenSanPham(int page, int size,String tensanpham) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepo.findByTenSanPham(tensanpham,pageable);
    }

    @Override
    public List<SanPham>findByHinhAnhURL(String hinhAnhURL) {
        return sanPhamRepo.findByHinhAnhURL(hinhAnhURL);
    }

    @Override
    public Page<SanPham> findByProductInPriceRange(int page, int size,Double minPrice, Double maxPrice) {
        Pageable pageable = PageRequest.of(page, size);
        return sanPhamRepo.findProductsInPriceRange(minPrice,maxPrice,pageable);
    }

    @Override
    public List<SanPham> getAll() {
       return sanPhamRepo.getAlll();
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
