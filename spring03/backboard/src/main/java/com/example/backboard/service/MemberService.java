package com.example.backboard.service;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backboard.entity.Member;
import com.example.backboard.repository.MemberRepository;
import com.example.backboard.security.MemberRole;

import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member setMember(String username, String email, String password) {
            Member member = Member.builder().username(username).email(email).regDate(LocalDateTime.now()).build();

            //BCryptPasswordEncoder 매번 새롭게 객체를 생성한다
            // 이것보다는 Bean등록해놓고 쓰는게 유지보수를 위해서 더 좋음
            // BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
            member.setPassword(passwordEncoder.encode(password)); // 암호화한 값을 DB에 저장
            member.setRegDate(LocalDateTime.now());
            member.setRole(MemberRole.USER); //일반사용자 권한
            this.memberRepository.save(member);

            return member;
    }

    // 사용자를 가져오는 메서드
    public Member getMember(String username) throws Exception{
        Optional<Member> member = this.memberRepository.findByUsername(username);
        if(member.isPresent())
        return member.get();
        else
            throw new Exception("Member not found!");
    }
}
