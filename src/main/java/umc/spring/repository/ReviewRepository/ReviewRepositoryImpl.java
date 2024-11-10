package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QReview;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;


    @Override
    public void insertReview(String title, String body, Float score, Member member, Store store) {
        Review review = Review.builder() // Builder 사용
                .title(title)
                .body(body)
                .score(score)
                .member(member)
                .store(store)
                .build();

        entityManager.persist(review);
    }
}
