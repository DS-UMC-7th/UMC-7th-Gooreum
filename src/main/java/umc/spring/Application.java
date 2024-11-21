package umc.spring;

import com.querydsl.core.Tuple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import umc.spring.domain.Member;
import umc.spring.domain.Store;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.service.MemberService.MemberQueryService;

import java.util.List;


@SpringBootApplication
@EnableJpaAuditing
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);

			// 파라미터 값 설정
			String name = "요아정";
			Float score = 4.0f;

			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);

			// 마이 페이지 화면 쿼리
			MemberQueryService memberService = context.getBean(MemberQueryService.class);

			Long memberId = 1L;  // 예시로 아이디 1을 사용

			System.out.println("Executing findMemberById with ID: " + memberId);

			List<Member> members = memberService.findMemberById(memberId);

			Member member = members.get(0);
			System.out.println("Name: " + member.getName());
			System.out.println("Email: " + member.getEmail());
			System.out.println("Point: " + member.getPoint());
			memberService.findMemberById(memberId)
					.forEach(System.out::println);

			// 리뷰 작성
			ReviewService reviewService = context.getBean(ReviewService.class);

			Long memberId2 = 1L;
			Long storeId = 1L;

			Member member2 = memberService.findMember(memberId2)
					.orElseThrow(() -> new IllegalArgumentException("Member not found"));
			Store store = storeService.findStore(storeId)
					.orElseThrow(() -> new IllegalArgumentException("Store not found"));

			String title = "좋은 가게";
			String body = "친절하고 음식이 맛있어요.";
			Float score2 = 4.5f;

			System.out.println("Adding review with title: " + title);
			reviewService.addReview(title, body, score2, member2, store);
			System.out.println("Review added successfully.");

			// 미션 조회
			MissionQueryService missionQueryService = context.getBean(MissionQueryService.class);

			// 미션 조회 테스트
			LocalDate lastCursorDeadline = LocalDate.now();
			String region = null;
			System.out.println("Executing findMissionWithStatusAndDeadline with lastCursorDeadline: " + lastCursorDeadline);

			List<Tuple> missions = missionQueryService.getMissionsWithStatusAndDeadline(lastCursorDeadline, region);
			System.out.println("Number of missions fetched: " + missions.size());
			// 미션 결과 출력
			missions.forEach(tuple -> {
				String storeName = tuple.get(0, String.class);  // store.name
				Integer reward = tuple.get(1, Integer.class);   // reward
				String missionSpec = tuple.get(2, String.class); // missionSpec
				String status = tuple.get(3, String.class);     // status

				System.out.println("Store Name: " + storeName);
				System.out.println("Reward: " + reward);
				System.out.println("Mission Spec: " + missionSpec);
				System.out.println("Status: " + status);
				System.out.println("-----");
			});

	};
}}
