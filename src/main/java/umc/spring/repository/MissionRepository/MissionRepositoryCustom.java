package umc.spring.repository.MissionRepository;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import com.querydsl.core.Tuple;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepositoryCustom {
//    List<Tuple> findMissionWithStatusAndDeadline(LocalDate lastCursorDeadline, String region);
    void insertMission(Store store, MissionRequestDTO missionRequestDTO);
}
