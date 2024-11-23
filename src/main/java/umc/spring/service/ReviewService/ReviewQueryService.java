package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryService implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreQueryService storeQueryService;

    public static Review toReview(ReviewRequestDTO requestDTO, Member member, Store store) {
        return Review.builder()
                .title(requestDTO.getTitle()) // 제목
                .body(requestDTO.getBody())   // 내용
                .score(requestDTO.getScore()) // 점수
                .member(member)               // 작성자
                .store(store)                 // 가게
                .build();
    }

    @Override
    public Review addReview(Long storeId, ReviewRequestDTO requestDTO) {
        Member hardcodedMember = Member.builder()
                .id(1L)
                .name("Hardcoded User")
                .build();

        // 가게 확인
        Store store = storeQueryService.findStore(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 가게를 찾을 수 없습니다."));

        // 리뷰 생성
        Review review = toReview(requestDTO, hardcodedMember, store);
        return reviewRepository.save(review);
    }
}
