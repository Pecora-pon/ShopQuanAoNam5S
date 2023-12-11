package com.example.demo.config;

import com.example.demo.entity.SanPham;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class SanPhamExel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<SanPham> listSanPham;

    public SanPhamExel(List<SanPham> listSanPham) {
        this.listSanPham =listSanPham;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("SanPham");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID Sản phẩm", style);
        createCell(row, 1, "Tên sản phẩm", style);
        createCell(row, 2, "Mô tả", style);
        createCell(row, 3, "Giá sản phẩm", style);
        createCell(row, 4, "Số lượng tồn", style);
        createCell(row, 5, "Màu sắc", style);
        createCell(row, 6, "Size", style);
        createCell(row, 7, "Chất liệu", style);
        createCell(row, 8, "Thương hiệu", style);
        createCell(row, 9, "Ngày tạo", style);
        createCell(row, 10, "Hình ảnh", style);


    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (SanPham sanPham:listSanPham) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, sanPham.getSanPhamID().toString(), style);
            createCell(row, columnCount++, sanPham.getTenSanPham(), style);
            createCell(row, columnCount++, sanPham.getMoTa(), style);
            createCell(row, columnCount++, sanPham.getGiaSanPham().toString(), style);
            createCell(row, columnCount++, sanPham.getSoLuongTon(), style);
            createCell(row, columnCount++, sanPham.getMauSac().getTenMauSac(), style);
            createCell(row, columnCount++, sanPham.getSize().getTenSize(), style);
            createCell(row, columnCount++, sanPham.getChatLieu().getTenChatLieu(), style);
            createCell(row, columnCount++, sanPham.getThuongHieu().getTenThuongHieu(), style);
            createCell(row, columnCount++, sanPham.getNgayTao().toString(), style);
            createCell(row, columnCount++, sanPham.getHinhAnhURL(), style);


        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
