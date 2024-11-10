package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryService implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public void addReview(String title, String body, Float score, Member member, Store store) {
        Review review = Review.builder()
                .title(title)
                .body(body)
                .score(score)
                .member(member)
                .store(store)
                .build();

        reviewRepository.save(review);
    }
}
