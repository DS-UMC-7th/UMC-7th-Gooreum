package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ChallengeMissionRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionQueryService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<Long> addMission(
            @ExistStore @PathVariable Long storeId,
            @RequestBody MissionRequestDTO missionRequestDTO) {

        Long missionId = missionCommandService.addMission(storeId, missionRequestDTO).getId();
        return ApiResponse.onSuccess(missionId);
    }

    @PatchMapping("/{missionId}/status")
    public ApiResponse<Long> updateMissionStatus(
            @PathVariable Long missionId,
            @RequestParam MissionStatus status) {
        Mission updatedMission = missionCommandService.updateMissionStatus(missionId, status);
        return ApiResponse.onSuccess(updatedMission.getId());
    }
}
