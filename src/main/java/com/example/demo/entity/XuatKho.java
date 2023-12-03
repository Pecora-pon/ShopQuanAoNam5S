package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name="XuatKho")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class XuatKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="XuatKhoID")
    private int xuatKhoID;
    @ManyToOne
    @JoinColumn(name = "MauSacID")
    private MauSac MauSac;
    @ManyToOne
    @JoinColumn(name = "SizeID")
    private Size Size;
    @ManyToOne
    @JoinColumn(name = "ChatLieuID")
    private ChatLieu ChatLieu;
    @Column(name="SoLuongXuat")
    private int soLuongXuat;
    @Column(name="NgayXuat")
    private LocalDate ngayXuat;
    @ManyToOne
    @JoinColumn(name="NhaCungCapID")
    private NhaCungCap NhaCungCap;
    @ManyToOne
    @JoinColumn(name="SanPhamID")
    private SanPham SanPham;

    @Column(name="trangThai")
    private int trangThai;
}
