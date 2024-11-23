package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reward;

    private LocalDate deadline;

    @Column(nullable = false, length = 50)
    private String missionSpec;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionStatus status = MissionStatus.PENDING;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
