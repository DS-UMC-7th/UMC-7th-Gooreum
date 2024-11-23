package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.Tuple;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.web.dto.MissionRequestDTO;

import java.time.LocalDate;
import java.util.List;

import static umc.spring.domain.enums.MissionStatus.CHALLENGING;
import static umc.spring.domain.enums.MissionStatus.COMPLETE;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QMemberMission memberMission = QMemberMission.memberMission;

/*
    @Override
    public List<Tuple> findMissionWithStatusAndDeadline(LocalDate lastCursorDeadline, String region) {

        BooleanBuilder builder = new BooleanBuilder();

        // 상태가 '진행 중' 또는 '진행 완료'인 조건
        builder.and(memberMission.status.in(CHALLENGING, COMPLETE));

        // deadline이 마지막 커서 기준보다 큰 조건
        builder.and(mission.deadline.after(lastCursorDeadline));

        if (region != null && !region.isEmpty()) {
            builder.and(mission.store.region.name.eq(region));
        }

        // 쿼리 실행
        return jpaQueryFactory
                .select(mission.store.name, mission.reward, mission.missionSpec, memberMission.status)
                // .select(mission)
                .from(mission)
                .join(store).on(mission.store.id.eq(store.id))
                .join(memberMission).on(mission.id.eq(memberMission.mission.id))
                .where(builder)
                .orderBy(mission.deadline.asc())
                .limit(15)
                .fetch();
    }
*/

    private final EntityManager entityManager;

    @Override
    public void insertMission(Store store, MissionRequestDTO missionRequestDTO) {
        // Mission 엔티티 빌더 사용하여 미션 생성
        Mission mission = Mission.builder()
                .reward(missionRequestDTO.getReward())
                .deadline(missionRequestDTO.getDeadline())
                .missionSpec(missionRequestDTO.getMissionSpec())
                .store(store) // 가게와 연결
                .build();

        // 미션 저장
        entityManager.persist(mission);
    }
}
