package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.MissionRequestDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;

//    @Override
//    public List<Tuple> getMissionsWithStatusAndDeadline(LocalDate lastCursorDeadline, String region) {
//        return missionRepository.findMissionWithStatusAndDeadline(lastCursorDeadline, region);
//    }

    public static Mission toMission(MissionRequestDTO requestDTO, Store store) {
        return Mission.builder()
                .reward(requestDTO.getReward())
                .deadline(requestDTO.getDeadline())
                .missionSpec(requestDTO.getMissionSpec())
                .store(store)    // 가게에 미션 연결
                .build();
    }

    @Override
    public Mission addMission(Long storeId, MissionRequestDTO missionRequestDTO) {

        // 가게 확인
        Store store = storeQueryService.findStore(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게를 찾을 수 없습니다."));

        // 미션 생성
        Mission mission = toMission(missionRequestDTO, store);
        return missionRepository.save(mission);
    }

    @Override
    public Mission updateMissionStatus(Long missionId, MissionStatus newStatus) {
        // 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 미션을 찾을 수 없습니다."));

        // 상태 업데이트
        mission.setStatus(newStatus);

        // 변경된 미션 저장
        return missionRepository.save(mission);
    }

}