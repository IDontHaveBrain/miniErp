package minierp.web.domain.entity.member;

import java.util.Optional;

public interface MemberCustomRepository {
    RequestMemberDTO findByUsername(String username);
    Optional<Member> findbyMemberId(String memberId);
}
