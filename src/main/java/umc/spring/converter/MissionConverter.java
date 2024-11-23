package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO requestDTO, Store store) {
        return Mission.builder()
                .reward(requestDTO.getReward())        // 보상
                .deadline(requestDTO.getDeadline())    // 마감일
                .missionSpec(requestDTO.getMissionSpec()) // 미션 설명
                .store(store)                          // 가게
                .build();
    }
}
