package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GiamGiaChiTiet")
public class GiamGiaChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GiamGiaChiTietID")
    private Integer giamGiaChiTietID;

    @Column(name ="SoTienGiam")
    private Integer soTienGiam;


    @ManyToOne
    @JoinColumn(name = "GiamGiaID")
    private GiamGia giamGia;

    @ManyToOne
    @JoinColumn(name="SanPhamID")
    private SanPham sanPham;
}
