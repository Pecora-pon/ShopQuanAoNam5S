package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.SanPham;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    boolean existsByTenSanPham(String tenSanPham);
    Page<SanPham> findByTinhTrang(Integer tinhTrang, Pageable pageable);
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

    @Query("SELECT sp FROM SanPham sp WHERE sp.tenSanPham =:tenSanPham")
    List<SanPham> findByTenSanPham1(@Param("tenSanPham") String tenSanPham);

    Optional<SanPham> findById(UUID sanPhamID);
     @Query("SELECT sp FROM SanPham sp WHERE sp.mauSac.mauSacID =:mauSacID")
    List<SanPham> findByMauSac_MauSacID(@Param("mauSacID") int tenMauSac);

    @Query("SELECT sp FROM SanPham sp WHERE sp.size.sizeID =:sizeID")
    List<SanPham> findBySize_SizeID(@Param("sizeID") int tenSize);
    @Query("SELECT sp FROM SanPham sp WHERE sp.chatLieu.chatLieuID =:chatLieuID")
    List<SanPham> findByChatLieu_ChatLieuID(@Param("chatLieuID") int tenChatLieu);
    @Query("SELECT sp FROM SanPham sp WHERE sp.thuongHieu.thuongHieuID =:thuongHieuID")
    List<SanPham> findByThuongHieu_ThuongHieuID(@Param("thuongHieuID") int tenthuongHieu);
    @Query("select sp from SanPham sp order by sp.ngayTao desc ")
    List<SanPham> sapxep();
    List<SanPham>findBySanPhamID(UUID sanPhamID);
    @Transactional
    @Modifying
    @Query(value = "Update SanPham set tinhTrang = 1 where sanPhamID =:sanPhamID",nativeQuery = true)
    void deleteByI(@Param("sanPhamID") UUID sanPhamID);
    @Query(value = "select * from SanPham p WHERE p.tinhTrang =0 order by p.sanPhamID desc",nativeQuery = true)
    List<SanPham> getAll();



}
