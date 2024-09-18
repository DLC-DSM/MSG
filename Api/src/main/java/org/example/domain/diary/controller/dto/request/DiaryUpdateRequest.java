package org.example.domain.diary.controller.dto.request;

import lombok.Getter;

@Getter
public class DiaryUpdateRequest {
    private String img;
    private String content;
    private long id;
}
