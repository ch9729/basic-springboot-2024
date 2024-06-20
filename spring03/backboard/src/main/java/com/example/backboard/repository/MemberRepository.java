package com.example.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backboard.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
    
}
