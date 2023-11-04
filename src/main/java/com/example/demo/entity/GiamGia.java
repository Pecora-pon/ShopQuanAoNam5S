package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GiamGia")
public class GiamGia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GiamGiaID")
    private Integer giamGiaID;

    @Column(name = "MaGiamGia")
    private String maGiamGia;

    @Column(name = "TenSuKien")
    private String tenSuKien;

    @Column(name = "NgayHetHan")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayHetHan;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "NhanVienID")
    private NhanVien nhanVien;


}
