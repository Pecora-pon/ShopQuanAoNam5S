package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu,Integer> {
    @Query("Select c from ChatLieu c where c.tenChatLieu like %?1%")
    List<ChatLieu>searchten(String keyword);
    @Query("Select c from ChatLieu c order by c.chatLieuID desc ")
    List<ChatLieu>getAl();
}
