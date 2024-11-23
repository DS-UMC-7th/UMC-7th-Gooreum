package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.validation.annotation.ExistStore;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<Long> addReview(
            @ExistStore @PathVariable Long storeId,
            @RequestBody @Valid ReviewRequestDTO requestDTO) {
        Long reviewId = reviewCommandService.addReview(storeId, requestDTO).getId();
        return ApiResponse.onSuccess(reviewId);
    }
}

