package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.responobject.Respon;
import com.example.demo.repository.ChatLieuRepository;
import com.example.demo.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepository.getAll();
    }



    @Override
    public Respon<ChatLieu> add(ChatLieu chatLieu) {
        Respon<ChatLieu>repon=new Respon<>();
        String tenChatLieu=chatLieu.getTenChatLieu().trim();
        ChatLieu ten=chatLieuRepository.searchtencl(tenChatLieu);
        if(ten==null){
            repon.setError("Tên đã tồn tại");
        }else {
            if (chatLieu.getTenChatLieu() != null && !chatLieu.getTenChatLieu().isEmpty()) {
                chatLieu.setTrangThai(0);
                chatLieu.setTenChatLieu(tenChatLieu);
                chatLieuRepository.save(chatLieu);
                repon.setStatus("Thành công");
            } else {
                repon.setError("Tên không được để trông");
            }
        }
        return repon;
    }

    @Override
    public Respon<ChatLieu> update(Integer chatLieuID, ChatLieu chatLieu) {
        Respon<ChatLieu> respon=new Respon<>();
        ChatLieu chatLieu1=detail(chatLieuID);
        if(chatLieu1 !=null){
            chatLieu1.setChatLieuID(chatLieu.getChatLieuID());
            chatLieu1.setTenChatLieu(chatLieu.getTenChatLieu());
            chatLieuRepository.save(chatLieu);
            respon.setStatus("Thành công");
        }else {
            respon.setError("Update không thành công");
        }
        return respon;
    }

    @Override
    public void delete(Integer chatLieuID) {
    chatLieuRepository.deleteById(chatLieuID);
    }

    @Override
    public ChatLieu detail(Integer chatLieuID) {
        return chatLieuRepository.findById(chatLieuID).orElse(null);
    }

    @Override
    public List<ChatLieu> findTen(String keyword) {
        return chatLieuRepository.searchten(keyword);
    }

    @Override
    public Page<ChatLieu> getPage(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        return chatLieuRepository.findAll(pageable);
    }
}
