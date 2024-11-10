package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;
import com.querydsl.core.Tuple;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepositoryCustom {
    List<Tuple> findMissionWithStatusAndDeadline(LocalDate lastCursorDeadline, String region);
}
