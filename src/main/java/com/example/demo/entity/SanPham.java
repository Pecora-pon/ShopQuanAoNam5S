
package com.example.demo.entity;

import com.example.demo.entity.ThuongHieu;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SanPham")
public class SanPham {

    @Id
    @Column(name = "SanPhamID")
    private UUID sanPhamID;

    @Column(name = "TenSanPham")
    private String tenSanPham;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @Column(name = "GiaSanPham")
    private Float giaSanPham;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @ManyToOne
    @JoinColumn(name = "MauSacID")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "SizeID")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "ChatLieuID")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "ThuongHieuID")
    private ThuongHieu thuongHieu;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "HinhAnhURL")
    private String hinhAnh;


}

