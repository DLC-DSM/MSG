package org.example.domain.diary.controller.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class DiaryWriteRequest {
    private Date date;
    private String content;
    private String img;
}
