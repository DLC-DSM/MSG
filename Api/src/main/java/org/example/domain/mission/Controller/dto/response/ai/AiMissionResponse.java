package org.example.domain.mission.Controller.dto.response.ai;

import lombok.Getter;

import java.util.Date;

@Getter
public class AiMissionResponse {
    String name;
    Date expireTime;
    Long coin;
}
