package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Member;
import umc.spring.domain.Store;

public interface ReviewRepositoryCustom {
    void insertReview(String title, String body, Float score, Member member, Store store);
}
