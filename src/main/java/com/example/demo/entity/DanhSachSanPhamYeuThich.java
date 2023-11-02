package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "DanhSachSanPhamYeuThich")
public class DanhSachSanPhamYeuThich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DanhSachSanPhamYeuThichID")
    private Integer danhSachSanPhamYeuThichID;

    @ManyToOne
    @JoinColumn(name = "DanhSachYeuThichID")
    private DanhSachYeuThich danhSachYeuThich;

    @ManyToOne
    @JoinColumn(name = "SanPhamID")
    private SanPham sanPham;


}

