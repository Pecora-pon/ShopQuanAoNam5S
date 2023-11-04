package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ThongTinVanChuyen")
public class ThongTinVanChuyen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ThongTinVanChuyenID")
    private Integer thongTinVanChuyenID;

    @Column(name = "DiaChi", columnDefinition = "NVARCHAR(MAX)")
    private String diaChi;

    @Column(name = "PhuongThuc", length = 255)
    private String phuongThuc;

    @Column(name = "TrangThai")
    private Integer trangThai;


}

