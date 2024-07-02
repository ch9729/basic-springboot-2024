package com.example.backboard.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {
    
    private Long rno;

    private String content;

    private LocalDateTime createDate;   //글생성일

    private LocalDateTime modifyDate; // 24.06.24 수정일 추가

    private String writer;

}
