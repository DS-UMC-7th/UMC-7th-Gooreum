package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionRequestDTO {
    private Integer reward;          // 보상
    private LocalDate deadline;      // 마감일
    private String missionSpec;      // 미션 설명
}
