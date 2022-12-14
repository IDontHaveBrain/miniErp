package minierp.web.domain.entity.member;

public interface MemberCustomRepository {
    RequestMemberDTO findByUsername(String username);
}
