package com.example.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backboard.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
    
}
