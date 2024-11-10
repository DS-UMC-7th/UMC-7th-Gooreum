package umc.spring.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;
import umc.spring.domain.QStore;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public List<Member> dynamicQueryWithBooleanBuilder(Long id) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (id != null) {
            predicate.and(member.id.eq(id));
        }

        return jpaQueryFactory
                .selectFrom(member)
                .where(predicate)
                .fetch();
    }
}
