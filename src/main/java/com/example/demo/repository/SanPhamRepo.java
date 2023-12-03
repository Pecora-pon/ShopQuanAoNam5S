package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.SanPham;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, UUID> {

    @Query("SELECT sp FROM SanPham sp WHERE sp.thuongHieu LIKE %?1%")
    List<SanPham> findByThuongHieuID(String thuongHieuID);

    @Query("SELECT sp FROM SanPham sp WHERE sp.mauSac LIKE %?1%")
    List<SanPham> findByMauSacID(String mauSacID);

    @Query("SELECT sp FROM SanPham sp WHERE sp.chatLieu LIKE %?1%")
    List<SanPham> findByChatLieuID(String chatLieuID);

    @Query("SELECT sp FROM SanPham sp WHERE sp.size LIKE %?1%")
    List<SanPham> findBySizeID(String sizeID);

    @Query("SELECT sp FROM SanPham sp WHERE sp.tenSanPham LIKE %?1%")
    List<SanPham> findByTenSanPham(String tenSanPham);

    @Query("SELECT sp FROM SanPham sp WHERE sp.hinhAnhURL LIKE %?1%")
    List<SanPham> findByHinhAnhURL(String hinhAnhURL);

    @Query("SELECT sp FROM SanPham sp WHERE sp.giaSanPham BETWEEN ?1 AND ?2")
    List<SanPham> findProductsInPriceRange(Double minPrice, Double maxPrice);
    @Query("SELECT sp FROM SanPham sp WHERE sp.tenSanPham =:tenSanPham")
    SanPham findByTen(@Param("tenSanPham") String tenSanPham);

    Optional<SanPham> findById(UUID sanPhamID);
//     @Query("SELECT sp FROM SanPham sp WHERE sp.mauSac LIKE %?1%")
//    List<SanPham> findByMauSac_MauSacID(@Param("mausac") String tenMauSac);

    @Query("select sp from SanPham sp order by sp.ngayTao desc ")
    List<SanPham> sapxep();
    List<SanPham>findBySanPhamID(UUID sanPhamID);
    @Transactional
    @Modifying
    @Query(value = "Update SanPham set trangThai = 1 where sanPhamID =:sanPhamID",nativeQuery = true)
    void deleteByI(@Param("sanPhamID") UUID sanPhamID);
    @Query(value = "select * from SanPham p WHERE p.trangThai =0 order by p.sanPhamID desc",nativeQuery = true)
    List<SanPham> getAll();



}
