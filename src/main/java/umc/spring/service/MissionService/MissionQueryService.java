package umc.spring.service.MissionService;

import com.querydsl.core.Tuple;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MissionQueryService {
//    List<Tuple> getMissionsWithStatusAndDeadline(LocalDate lastCursorDeadline, String region);
    Mission addMission(Long storeId, MissionRequestDTO requestDTO);
    Mission updateMissionStatus(Long missionId, MissionStatus newStatus);
}