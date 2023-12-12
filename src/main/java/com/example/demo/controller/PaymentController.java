package com.example.demo.controller;

import com.example.demo.DTO.PaymentResDTO;
import com.example.demo.config.Config;
import com.example.demo.config.VNPayService;
import com.example.demo.entity.DonHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepo;
import com.example.demo.service.SanPhamService;
import com.example.demo.service.ThanhToanService;
import jakarta.servlet.http.HttpServletRequest;
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
import java.util.*;
@Controller
public class PaymentController {

    @Autowired
    private VNPayService vnPayService;
   @Autowired
    KhachHangRepo khachHangRepo;
   @Autowired
    ThanhToanService thanhToanService;
    @PostMapping("/submitOrder")
    public String submidOrder(@RequestParam("amount") long orderTotal,
                              HttpServletRequest request, @ModelAttribute("t") DonHang donHang, @RequestParam("gioHangID[]")List<Integer>  giohangID, @RequestParam("amount") float tt, Model model, Principal principal) throws UnsupportedEncodingException {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(orderTotal, baseUrl);
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        donHang.setKhachHang(khachHang);
        DonHang donHang1= thanhToanService.themmoi(donHang,giohangID,tt);
        model.addAttribute("t",donHang1);
        return "redirect:" + vnpayUrl;
    }

    @PostMapping("/submitOrder1")
    public String submidOrder1(@RequestParam("amount") Long orderTotal,
                              HttpServletRequest request, @ModelAttribute("t") DonHang donHang,@RequestParam("soLuongDat")int sl, @RequestParam("sanPhamID") UUID id, @RequestParam("amount") float tt, Model model, Principal principal) throws UnsupportedEncodingException {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(orderTotal, baseUrl);
        String logname=principal.getName();
        KhachHang khachHang=khachHangRepo.findByUsername(logname);
        donHang.setKhachHang(khachHang);
        DonHang donHang2 = thanhToanService.themmoingay(donHang,id,sl,tt);
        model.addAttribute("t",donHang2);
        return "redirect:" + vnpayUrl;
    }


    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request, Model model){
        int paymentStatus = vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "shop/thong-bao" : "shop/thatbai";
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

