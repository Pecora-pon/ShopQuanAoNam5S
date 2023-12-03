package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.FileUploaderService;
import com.example.demo.service.MauSacService;
import lombok.Value;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class FileUploaderServiceImpl implements FileUploaderService {
@Autowired
private MauSacRepo mauSacRepo;
@Autowired
    ThuongHieuRepo thuongHieuRepo;
@Autowired
    ChatLieuRepository chatLieuRepo;
@Autowired
    SizeRepo sizeRepo;
@Autowired
    SanPhamRepo sanPhamRepo;
    @Override
    public void uploadFile(MultipartFile fileLoaction) throws IOException {
        try (InputStream inputStream = fileLoaction.getInputStream()) {
            // Create a Workbook instance using the provided InputStream
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getCell(0) == null || row.getCell(0).getStringCellValue().trim().isEmpty()) {
                    // Skip empty row
                    continue;
                }

                String ten = row.getCell(0).getStringCellValue();
                SanPham tenSanPham = sanPhamRepo.findByTen(ten);
                if (tenSanPham == null) {
                    SanPham sanPham = new SanPham();
                    sanPham.setTenSanPham(ten);
                    sanPham.setMoTa(row.getCell(1).getStringCellValue());
//                float giaSanPham = (float) row.getCell(2).getNumericCellValue();
//                sanPham.setGiaSanPham(giaSanPham);
//                int soLuongTon = (int) row.getCell(3).getNumericCellValue();
//                sanPham.setSoLuongTon(soLuongTon);
//                int tinhTrang = (int) row.getCell(4).getNumericCellValue();
//                sanPham.setTinhTrang(tinhTrang);
                    sanPham.setGiaSanPham((float) row.getCell(2).getNumericCellValue());
                    int soLuongTon = (int) row.getCell(3).getNumericCellValue();
                    sanPham.setSoLuongTon(soLuongTon);
                    sanPham.setTinhTrang(0);
                    //Mau Sac
                    String tenMauSac = row.getCell(4).getStringCellValue();  // Assuming the foreign key is in the second column
//
                    MauSac ms = mauSacRepo.searchBytenms(tenMauSac);
                    if (ms == null) {
                        ms = new MauSac();
                        ms.setTenMauSac(tenMauSac);
                        mauSacRepo.save(ms);
                    }
                    sanPham.setMauSac(ms);
                    //Size
                    String tenSize = row.getCell(5).getStringCellValue();  // Assuming the foreign key is in the second column
//
                    Size size = sizeRepo.searchByten(tenSize);
                    if (size == null) {
                        size = new Size();
                        size.setTenSize(tenSize);
                        sizeRepo.save(size);
                    }
//
                    sanPham.setSize(size);
                    //ChatLieu
                    String tenChatLieu = row.getCell(6).getStringCellValue();  // Assuming the foreign key is in the second column
                    ChatLieu chatLieu = chatLieuRepo.searchtencl(tenChatLieu);
                    if (chatLieu == null) {
                        chatLieu = new ChatLieu();
                        chatLieu.setTenChatLieu(tenChatLieu);
                        chatLieuRepo.save(chatLieu);
                    }
                    sanPham.setChatLieu(chatLieu);
                    //Thuong Hieu
                    String tenThuongHieu = row.getCell(7).getStringCellValue();  // Assuming the foreign key is in the second column
                    ThuongHieu thuongHieu = thuongHieuRepo.searchByten(tenThuongHieu);
                    if (thuongHieu == null) {
                        thuongHieu = new ThuongHieu();
                        thuongHieu.setTenThuongHieu(tenThuongHieu);
                        thuongHieuRepo.save(thuongHieu);
                    }
                    sanPham.setThuongHieu(thuongHieu);
                    sanPham.setNgayTao(LocalDate.now());
                    sanPham.setHinhAnhURL(row.getCell(8).getStringCellValue());
                    sanPhamRepo.save(sanPham);
                }
            }
            workbook.close();
//            file.close();
        }
    }
}
