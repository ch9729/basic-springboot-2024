package com.example.backboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backboard.service.MailService;
import com.example.backboard.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mail")
@RequiredArgsConstructor
@Controller
@Slf4j
public class MailController {
     private final MemberService memberService;

    private final MailService mailService;

    @PostMapping("/reset-mail")
    public String reset_mail(Model model,@RequestParam("email") String email) {
        
        // DB에서 메일 주소가 있는지 확인
        // 있다면 초기화메일을 보내고
        // 없다면 에러를 발생
        try{
            memberService.getMemberByEmail(email);
            Boolean result = mailService.sendResetPaswordEmail(email);
            if(result){
                log.info("▶▶▶▶▶▶▶▶ 초기화 메일 전송 성공!!");
                model.addAttribute("result", "초기화 메일 전송 성공!!");
            }
            else{
                
                log.info("▶▶▶▶▶▶▶▶ 초기화 메일 전송 실패!!1");
                model.addAttribute("result", "초기화 전송에 실패했습니다!! 관리자에게 문의해주세요");
            }
        }catch(Exception e){
            
            log.info("▶▶▶▶▶▶▶▶ 초기화 메일 전송 실패!!22");
            model.addAttribute("result", "초기화 전송에 실패했습니다!! 사용자가 없습니다!!");
        }
        log.info("▶▶▶▶▶ reset.html에서 넘어온 이메일{}",email);
        
        return "member/reset-result"; //member/reset-result.html을 작성해야 한다.
    }
}
