package com.lyj.springdemo.dto;

import lombok.*;

import java.time.LocalDate;

@Data  //getter,setter 자동생성
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;

}
