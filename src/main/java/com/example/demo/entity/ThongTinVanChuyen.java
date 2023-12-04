package com.example.demo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.bridge.IMessage;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;

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

    @NotBlank(message = "Không được để trống")
    @Column(name = "DiaChi", columnDefinition = "NVARCHAR(MAX)")
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    @Column(name = "PhuongThuc", length = 255)
    private String phuongThuc;

    @ManyToOne
    @JoinColumn(name = "KhachHangID")
    private  KhachHang khachHang;


    @Column(name = "TrangThai")
    private Integer trangThai;


}

