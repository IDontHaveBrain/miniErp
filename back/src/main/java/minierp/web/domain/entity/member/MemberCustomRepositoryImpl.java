package minierp.web.domain.entity.member;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import static minierp.web.domain.entity.member.QMember.member;

public class MemberCustomRepositoryImpl implements MemberCustomRepository{

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public RequestMemberDTO findByUsername (String username) {

        return queryFactory
                .select(Projections.constructor(
                        RequestMemberDTO.class,
                        member.memberId,
                        member.username,
                        member.pw,
                        member.roles
                )).from(member)
                .where(member.username.eq(username))
                .fetchOne();
    }
}