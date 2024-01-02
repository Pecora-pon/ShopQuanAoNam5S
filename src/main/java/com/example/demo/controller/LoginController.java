
package com.example.demo.controller;

import com.example.demo.repository.DonHangChiTietRepo;
import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private DonHangChiTietRepo donHangChiTietRepo;
    @GetMapping("/your-api-endpoint")
    public List<Object[]> getDataForSelectedDate(@RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate) {
        return donHangChiTietRepo.getTotalQuantityByMonthInYear2023(selectedDate);
    }
}

