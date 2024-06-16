package com.example.spring02.domain;

import java.time.LocalDateTime;

import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.ToString;

@Data
public class Todo {
    private int tno;

    private String title;

    private LocalDateTime dueDate;

    private String writer;

    private int isDone;
}