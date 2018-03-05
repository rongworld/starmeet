package com.ncuhome.startmeet.dao;

import com.ncuhome.startmeet.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDao extends JpaRepository<Message,Integer>{
    List<Message> findByUserId(Integer userId);
}
