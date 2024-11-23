package umc.spring.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChallengeMissionRequestDTO {
    private Long memberId;
    private Long missionId;
}
