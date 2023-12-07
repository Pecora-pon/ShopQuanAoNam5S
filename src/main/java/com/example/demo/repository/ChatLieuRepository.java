package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.Size;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu,Integer> {
    boolean existsByTenChatLieu(String tenChatLieu);
    Page<ChatLieu> findByTrangThai(Integer tinhTrang, Pageable pageable);
    @Query("Select c from ChatLieu c where c.tenChatLieu like %?1%")
    List<ChatLieu>searchten(String keyword);
    @Query("Select c from ChatLieu c where c.tenChatLieu =:tenChatLieu and  c.trangThai=0")
    ChatLieu searchtencl(@Param("tenChatLieu") String keyword);
    @Query("Select c from ChatLieu c order by c.chatLieuID desc ")
    List<ChatLieu>getAl();
    @Transactional
    @Modifying
    @Query(value = "Update ChatLieu set trangThai = 1 where chatLieuID =:chatLieuID",nativeQuery = true)
    void deleteByI(@Param("chatLieuID") int chatLieuID);
    @Query(value = "select * from ChatLieu p WHERE p.trangThai =0 order by p.chatLieuID desc",nativeQuery = true)
    List<ChatLieu> getAll();
}
