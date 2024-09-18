package org.example.domain.diary.controller.dto.response;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class DiaryPageResponse {
    private Date date;
    private long id;
}
