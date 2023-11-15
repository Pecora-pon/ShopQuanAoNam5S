package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT sp FROM SanPham sp WHERE sp.giaSanPham BETWEEN ?1 AND ?2")
    List<SanPham> findProductsInPriceRange(Double minPrice, Double maxPrice);


    Optional<SanPham> findById(UUID sanPhamID);

    @Query("select sp from SanPham sp order by sp.ngayTao desc ")
    List<SanPham> sapxep();
    List<SanPham>findBySanPhamID(UUID sanPhamID);

}
