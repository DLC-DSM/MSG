package org.example.domain.diary.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.catalina.connector.Response;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DiaryReadResponse {
    Date date;
    String content;
    String img;
}
