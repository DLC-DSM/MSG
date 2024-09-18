package org.example.domain.mission.Controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class MissionResponse {
    private long id;
    private String text;
    private Date date;
    private boolean completed;
}
