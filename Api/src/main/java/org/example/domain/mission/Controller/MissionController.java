package org.example.domain.mission.Controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.mission.Controller.dto.request.MissionIdRequest;
import org.example.domain.mission.Controller.dto.response.MissionResponse;
import org.example.domain.mission.service.MissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;
    @GetMapping("/resolved")
    List<MissionResponse> resolved (){return missionService.resolved();}

    @PostMapping("/confirm")
    void confirm(@RequestBody MissionIdRequest missionIdRequest){missionService.confirm(missionIdRequest);}

    @GetMapping("/get")
    List<MissionResponse> get(){return missionService.get();}
}
