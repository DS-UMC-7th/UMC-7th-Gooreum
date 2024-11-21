package umc.spring.service.MissionService;

import com.querydsl.core.Tuple;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    List<Tuple> getMissionsWithStatusAndDeadline(LocalDate lastCursorDeadline, String region);
}