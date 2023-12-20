package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.service.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller

public class ChatLieuController {
    @Autowired
    ChatLieuService chatLieuService;
    @GetMapping("/chat-lieu")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAll(Model model) {
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        model.addAttribute("listChatLieu",chatLieuList);
        model.addAttribute("cl",new ChatLieu());
        return "sanpham/chatlieu";
    }
    @RequestMapping(value = "/chat-lieu-add",method = RequestMethod.POST)
    public String addChatLieu(@Valid @ModelAttribute("cl") ChatLieu chatLieu, BindingResult result, Model model,RedirectAttributes redirectAttributes){
        Respon<ChatLieu> respon=chatLieuService.add(chatLieu);
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        model.addAttribute("listChatLieu",chatLieuList);
        redirectAttributes.addFlashAttribute("repon",respon);
        return "redirect:/chat-lieu/page";
    }
    @RequestMapping("/chat-lieu/delete/{chatLieuID}")
    public String delete(@PathVariable("chatLieuID") Integer chatLieuID,Model model){
        chatLieuService.delete(chatLieuID);
//        List<ChatLieu> chatLieuList = chatLieuService.getAll();
//        model.addAttribute("listChatLieu",chatLieuList);
        return "redirect:/chat-lieu/page";
    }
    @RequestMapping("/chat-lieu-view-update/{chatLieuID}")
    public String viewUpdate(@PathVariable("chatLieuID") Integer chatLieuID,Model model){
        ChatLieu chatLieu = chatLieuService.detail(chatLieuID);
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        model.addAttribute("listChatLieu",chatLieuList);
        model.addAttribute("cl",chatLieu);
        return "sanpham/chatlieu-update";
    }
    @RequestMapping(value = "/chat-lieu/update/{chatLieuID}",method = RequestMethod.POST)
    public String update(@PathVariable("chatLieuID") Integer chatLieuID, ChatLieu chatLieu, Model model, RedirectAttributes redirectAttributes){
        Respon<ChatLieu> respon= chatLieuService.update(chatLieuID,chatLieu);
        List<ChatLieu> chatLieuList = chatLieuService.getAll();
        model.addAttribute("listChatLieu",chatLieuList);
        redirectAttributes.addFlashAttribute("repon",respon);
        return "redirect:/chat-lieu/page";
    }
    @RequestMapping("/chat-lieu/search")
    public String search(Model model,
                         @RequestParam("keyword") String keyword){
        List<ChatLieu> chatLieuList = chatLieuService.findTen(keyword);
        model.addAttribute("listChatLieu",chatLieuList);
        model.addAttribute("cl",new ChatLieu());
        return "sanpham/chatlieu";
    }
    @RequestMapping("/chat-lieu/page")
    public String page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "3") int size,
                       Model model,
                       @Param("keyword") String keyword){
        Page<ChatLieu> page1 = chatLieuService.getPage(page,size);
        List<ChatLieu> chatLieuList =page1.getContent();
        List<ChatLieu> chatLieuList1 = chatLieuService.getAll();
        if(keyword !=null){
            chatLieuList     = this.chatLieuService.findTen(keyword);
        }
        int totalItems = chatLieuList1.size();
        int itemsPerPage = size;
        int totalPages = (int) Math.floor((double) totalItems / itemsPerPage);
        int currentPage = page;
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("itemsPerPage", itemsPerPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listChatLieu",chatLieuList);
        model.addAttribute("cl",new ChatLieu());
        return "sanpham/chatlieu";
    }

}
