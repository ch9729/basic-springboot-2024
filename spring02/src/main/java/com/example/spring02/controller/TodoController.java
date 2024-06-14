package com.example.spring02.controller;

import java.util.List;
import org.springframework.stereotype.Controller;

import com.example.spring02.domain.Todo;
import com.example.spring02.service.TodoService;

// JavaEE 9 이전엔
// import javax.annotation.Resource;
// JavaEE 9 이후
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoController {
    
    @Resource
    TodoService todoService;

    // localhost:8091/todos 요청하면 실행되는 
    @GetMapping("/todos")
    public List<Todo> getMethodName() throws Exception {
       List<Todo> allTodos = todoService.getTodos();
        return allTodos;
    }
    
}
