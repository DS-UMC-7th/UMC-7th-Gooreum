package umc.spring.service.MissionService;

import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Tuple> getMissionsWithStatusAndDeadline(LocalDate lastCursorDeadline, String region) {
        return missionRepository.findMissionWithStatusAndDeadline(lastCursorDeadline, region);
    }
}