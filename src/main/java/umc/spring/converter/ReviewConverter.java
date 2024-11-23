package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;

public class ReviewConverter {

    // ReviewRequestDTO를 Review 엔티티로 변환하는 메서드
    public static Review toReview(ReviewRequestDTO requestDTO, Member member, Store store) {
        return Review.builder()
                .title(requestDTO.getTitle()) // 제목
                .body(requestDTO.getBody())   // 내용
                .score(requestDTO.getScore()) // 점수
                .member(member)               // 작성자 (하드코딩된 Member)
                .store(store)                 // 가게
                .build();
    }
}
