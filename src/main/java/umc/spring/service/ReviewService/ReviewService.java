package umc.spring.service.ReviewService;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewService {
    Review addReview(Long storeId, ReviewRequestDTO requestDTO);
}

