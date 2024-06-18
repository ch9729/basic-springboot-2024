package com.example.backboard.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backboard.entity.Board;
import com.example.backboard.service.BoardService;

import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RequestMapping("/board") // Restful URL은 /board로 시작
@Controller
public class BoardController {
    
    private final BoardService boardService;

    //@RequestMapping("/list", method=RequestMethod.GET) //아래와 동일 기능
    //Model -> controller에 있는 객체를 View로 보내주는 역할을 하는 객체
    @GetMapping("/list")
    public String  list(Model model) {
        List<Board>boardList = this.boardService.getList();
        model.addAttribute("boardList", boardList); //thymeleaf, mustache, jsp등 view로 보내는 기능!!!
        return "board/list"; //templates/board/list.html 렌더링해서 리턴하라!
    }
    @GetMapping("/detail/{bno}")
    public String detail(@PathVariable("bno") Long bno,Model model) throws Exception{
        Board board = boardService.getBoard(bno);
        model.addAttribute("board",board);
        return "board/detail";
    }

    
}
