package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {

    @NotBlank(message = "리뷰 제목은 필수입니다.")
    private String title;

    @NotBlank(message = "리뷰 내용은 필수입니다.")
    private String body;

    @NotNull(message = "점수는 필수입니다.")
    @Min(value = 0, message = "점수는 0 이상이어야 합니다.")
    @Max(value = 5, message = "점수는 5 이하이어야 합니다.")
    private Float score;
}

