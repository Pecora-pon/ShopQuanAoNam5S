package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.Size;
import com.example.demo.entity.responobject.Respon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAll();

    Respon<ChatLieu> add(ChatLieu chatLieu);

   Respon<ChatLieu>  update(Integer chatLieuID, ChatLieu chatLieu);

    void delete(Integer chatLieuID);

    ChatLieu detail(Integer chatLieuID);
    List<ChatLieu> findTen(String keyword);
    Page<ChatLieu>getPage(int pageNumber,int pageSize);
}
