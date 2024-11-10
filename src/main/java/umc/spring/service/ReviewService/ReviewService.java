package umc.spring.service.ReviewService;

import umc.spring.domain.Member;
import umc.spring.domain.Store;

public interface ReviewService {
    void addReview(String title, String body, Float score, Member member, Store store);
}

