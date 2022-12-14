package minierp.web.service;

import minierp.web.domain.entity.member.MemberRepository;
import minierp.web.domain.entity.member.RequestMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public RequestMemberDTO join(RequestMemberDTO member) {
        return memberRepository.findByUsername(member.getUsername());
    }

}
