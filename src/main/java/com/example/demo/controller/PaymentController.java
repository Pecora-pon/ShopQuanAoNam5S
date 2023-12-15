package com.example.demo.controller;

import com.example.demo.DTO.PaymentResDTO;
import com.example.demo.config.Config;
import com.example.demo.config.VNPayService;
import com.example.demo.entity.DonHang;
import com.example.demo.entity.DonHangChiTiet;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.GioHangRepo;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ThanhToanService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
@Controller
public class PaymentController {
    @Autowired
    public HttpSession session;
    @Autowired
    private VNPayService vnPayService;
    @Autowired
    KhachHangRepo khachHangRepo;
    @Autowired
    ThanhToanService thanhToanService;
    @Autowired
    GioHangRepo gioHangRepo;
    @PostMapping("/submitOrder")
    public String submidOrder(@RequestParam("amount") long orderTotal,
                              HttpServletRequest request, @ModelAttribute("t") DonHang donHang,
                              @ModelAttribute("t2") DonHangChiTiet donHangChiTiet, @RequestParam("gioHangID[]")List<Integer>  giohangID, @RequestParam("amount") Float tt,@RequestParam("trangThai")int trang, Model model, Principal principal) throws UnsupportedEncodingException {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        // Lưu đối tượng DonHangChiTiet vào session
        session.setAttribute("ttSession", tt);
        String vnpayUrl = vnPayService.createOrder(orderTotal, baseUrl);
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        donHang.setKhachHang(khachHang);
//        List<GioHang> gioHangList = gioHangRepo.findByKhachHang(khachHang);
        List<GioHang> gioHangList = new ArrayList<>();
        for (Integer gh : giohangID) {
            GioHang gioHangItem = gioHangRepo.getById(gh);
            gioHangItem.getSanPham().getSanPhamID();
            donHangChiTiet.setSanPham(gioHangItem.getSanPham());
            gioHangList.add(gioHangItem);
        }
        session.setAttribute("trangSession",trang);
        session.setAttribute("donHangSession", donHang);
        session.setAttribute("donHangChiTietSession", donHangChiTiet);
        session.setAttribute("gioHangListSession", gioHangList);
        return "redirect:" + vnpayUrl;
    }
    @PostMapping("/submitOrder1")
    public String submidOrder1(@RequestParam("amount") Long orderTotal,
                               DonHangChiTiet donHangChiTiet,HttpServletRequest request, @ModelAttribute("t") DonHang donHang,@RequestParam("soLuongDat")int sl,@RequestParam("trangThai")int trang, @RequestParam("sanPhamID") UUID id, @RequestParam("amount") float tt, Model model,
            SanPham sanPham, Principal principal) throws UnsupportedEncodingException {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder1(orderTotal, baseUrl);
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        session.setAttribute("donHangSession", donHang);
        session.setAttribute("ttSession", tt);
        session.setAttribute("trangSession", trang);
        session.setAttribute("slSession", sl);
        session.setAttribute("sanPhamSession",sanPham);
        donHang.setKhachHang(khachHang);
        return "redirect:" + vnpayUrl;
    }
    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request, Model model, HttpSession session){

        int paymentStatus = vnPayService.orderReturn(request);
        if(paymentStatus == 1){
            DonHang donHangFromSession = (DonHang) session.getAttribute("donHangSession");
            List<GioHang> gioHangList = (List<GioHang>) session.getAttribute("gioHangListSession");
//        List<Integer> gioHangIDs = (List<Integer>) session.getAttribute("gioHangListSession"); // Sửa thành List<Integer>

            DonHangChiTiet donHangChiTietFromSession = (DonHangChiTiet) session.getAttribute("donHangChiTietSession"); // Lấy đối tượng DonHangChiTiet từ session
            Float tt = (Float) session.getAttribute("ttSession");
            int trang=(int) session.getAttribute("trangSession");
            String vnp_ResponseCode = request.getParameter("vnp_ResponseCode");
            String orderInfo = request.getParameter("vnp_OrderInfo");
            String paymentTime = request.getParameter("vnp_PayDate");
            String transactionId = request.getParameter("vnp_TransactionNo");
            String totalPrice = request.getParameter("vnp_Amount");
            model.addAttribute("orderId", orderInfo);
            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("paymentTime", paymentTime);
            model.addAttribute("transactionId", transactionId);
            DonHang donHang1 = thanhToanService.themmoi2(donHangFromSession,gioHangList,tt,donHangChiTietFromSession,trang);
            model.addAttribute("t",donHang1);
            session.removeAttribute("donHangSession");
            session.removeAttribute("ttSession");
            return "shop/thong-bao";

        }else {
            session.removeAttribute("gioHangListSession");
            session.removeAttribute("donHangSession");
            session.removeAttribute("ttSession");
            session.removeAttribute("donHangChiTietSession");
            session.removeAttribute("trangSession");
            return "redirect:/that-bai";

        }

    }


    @GetMapping("/vnpay-payment1")
    public String GetMapping1(HttpServletRequest request, Model model, HttpSession session){

        int paymentStatus = vnPayService.orderReturn(request);
        if(paymentStatus == 1){
            DonHang donHangFromSession = (DonHang) session.getAttribute("donHangSession");

            Float tt = (Float) session.getAttribute("ttSession");
            int sl = (int) session.getAttribute("slSession");
            SanPham sanPham = (SanPham) session.getAttribute("sanPhamSession");
            UUID sanPhamId = sanPham.getSanPhamID();

            String vnp_ResponseCode = request.getParameter("vnp_ResponseCode");
            int trang=(int)session.getAttribute("trangSession");
            String orderInfo = request.getParameter("vnp_OrderInfo");
            String paymentTime = request.getParameter("vnp_PayDate");
            String transactionId = request.getParameter("vnp_TransactionNo");
            String totalPrice = request.getParameter("vnp_Amount");
            model.addAttribute("orderId", orderInfo);
            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("paymentTime", paymentTime);
            model.addAttribute("transactionId", transactionId);
            DonHang donHang1 = thanhToanService.themmoingay(donHangFromSession,sanPhamId,sl,tt,trang);
            model.addAttribute("t",donHang1);
            session.removeAttribute("donHangSession");
            session.removeAttribute("ttSession");
            session.removeAttribute("slSession");
            return "shop/thong-bao";

        }else {
            session.removeAttribute("gioHangListSession");
            session.removeAttribute("donHangSession");
            session.removeAttribute("ttSession");
            session.removeAttribute("donHangChiTietSession");
            session.removeAttribute("trangSession");
            return "redirect:/that-bai";

        }

    }



//    @PostMapping(value="/melusinepay",produces = "text/html; charset=UTF-8")
//    public String getPay(@RequestParam("totalPrice") long totalPrice) throws UnsupportedEncodingException{
//
//        String vnp_Version = "2.1.0";
//        String vnp_Command = "pay";
//        String orderType = "other";
//        long amount = totalPrice*100;
//        String bankCode = "NCB";
//
//        String vnp_TxnRef = Config.getRandomNumber(8);
//        String vnp_IpAddr = "127.0.0.1";
//
//        String vnp_TmnCode = Config.vnp_TmnCode;
//
//        Map<String, String> vnp_Params = new HashMap<>();
//        vnp_Params.put("vnp_Version", vnp_Version);
//        vnp_Params.put("vnp_Command", vnp_Command);
//        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
//        vnp_Params.put("vnp_Amount", String.valueOf(amount));
//        vnp_Params.put("vnp_CurrCode", "VND");
//
//        vnp_Params.put("vnp_BankCode", bankCode);
//        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
//        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
//        vnp_Params.put("vnp_OrderType", orderType);
//
//        vnp_Params.put("vnp_Locale", "vn");
//        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
//        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
//
//        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//        String vnp_CreateDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
//
//        cld.add(Calendar.MINUTE, 15);
//        String vnp_ExpireDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
//
//        List fieldNames = new ArrayList(vnp_Params.keySet());
//        Collections.sort(fieldNames);
//        StringBuilder hashData = new StringBuilder();
//        StringBuilder query = new StringBuilder();
//        Iterator itr = fieldNames.iterator();
//        while (itr.hasNext()) {
//            String fieldName = (String) itr.next();
//            String fieldValue = (String) vnp_Params.get(fieldName);
//            if ((fieldValue != null) && (fieldValue.length() > 0)) {
//                //Build hash data
//                hashData.append(fieldName);
//                hashData.append('=');
//                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
//                //Build query
//                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
//                query.append('=');
//                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
//                if (itr.hasNext()) {
//                    query.append('&');
//                    hashData.append('&');
//                }
//            }
//        }
//        String queryUrl = query.toString();
//        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
//        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
//        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
//
//        return paymentUrl;
}
