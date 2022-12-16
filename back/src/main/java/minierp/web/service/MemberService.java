package minierp.web.service;

import minierp.web.domain.entity.member.Member;
import minierp.web.domain.entity.member.MemberRepository;
import minierp.web.domain.entity.member.RequestMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public RequestMemberDTO join(RequestMemberDTO member) {
        return memberRepository.findByUsername(member.getUsername());
    }

    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

}
