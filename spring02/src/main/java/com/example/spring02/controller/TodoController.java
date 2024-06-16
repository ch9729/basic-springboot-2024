package com.example.spring02.controller;

import java.util.List;

import com.example.spring02.domain.Todo;
import com.example.spring02.service.TodoService;

// JavaEE 9 이전엔
// import javax.annotation.Resource;
// JavaEE 9 이후
import jakarta.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;

@Controller
public class TodoController {

    @Resource
    TodoService todoService;

    // localhost:8091/todos 요청하면 실행되는 
    @GetMapping("/todos")
    public String getTodos(Model model) throws Exception {
        List<Todo> allTodos = todoService.getTodos();
        model.addAttribute("todoList", allTodos); // view에 model로 todoList를 전달
        return "todolist";
    }

    // http://localhost:8091/todo.do?tno=1
    // http://localhost:8091/todo/1
    @GetMapping("/todo/{tno}")
    public @ResponseBody Todo getTodo(@PathVariable("tno") int tno) throws Exception {
        return todoService.getTodo(tno);
    }
}