package org.example.domain.mission.Controller.dto.response.ai;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AiResponse {
    List<AiMissionResponse> missionResponseList;
}
