package org.example.domain.mission.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.domain.mission.Controller.dto.request.MissionIdRequest;
import org.example.domain.mission.Controller.dto.response.ai.AiMissionResponse;
import org.example.domain.mission.Controller.dto.response.MissionResponse;
import org.example.domain.mission.Controller.dto.response.ai.AiResponse;
import org.example.domain.mission.entity.MissionEntity;
import org.example.domain.mission.repository.MissionRepository;
import org.example.global.User.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
@RequiredArgsConstructor
@Service
public class MissionService {
    private final MissionRepository missionRepository;
    public List<MissionResponse> resolved (){
        return missionRepository.findAllByCompleted(true)
                .stream()
                .map(a->new MissionResponse(
                        a.getId(),
                        a.getText(),
                        a.getDate(),
                        a.isCompleted()
                    )).toList();
    }
    public void confirm(MissionIdRequest missionIdRequest) {
        MissionEntity mission = missionRepository.findAllById(missionIdRequest.getMissionId());
        //Ai 연동 해야하는
        missionRepository.save(mission);
    }

    @Transactional
    public List<MissionResponse> get() throws NullPointerException{
        List<MissionEntity> list = missionRepository.findAllByDateAfter(new Date());
        if(list.isEmpty()){
            RestTemplate restTemplate = new RestTemplate();
            String url = "";
            ResponseEntity<AiResponse> responseBody = restTemplate.getForEntity(url, AiResponse.class);
            list = responseBody.getBody().getMissionResponseList().stream().map(
                    a -> MissionEntity.builder()
                            .text(a.getName())
                            .date(a.getExpireTime())
                            .coin(a.getCoin())
                            .user(new UserEntity())//jwt 관련으로 User 받아오기 해야함
                            .build()
                    ).toList();
            list.forEach(a->missionRepository.save(a));

        }
        return list
                .stream()
                .map(a->new MissionResponse(
                        a.getId(),
                        a.getText(),
                        a.getDate(),
                        a.isCompleted()
                )).toList();

    }

}
