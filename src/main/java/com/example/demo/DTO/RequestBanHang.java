package com.example.demo.DTO;

import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBanHang {
    private DonHang donHang;
    private DonHangChiTiet donHangChiTiet;
}
