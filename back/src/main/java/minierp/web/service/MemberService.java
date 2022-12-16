package minierp.web.service;

import minierp.web.domain.entity.member.Member;
import minierp.web.domain.entity.member.MemberRepository;
import minierp.web.domain.entity.member.RequestMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static minierp.web.domain.entity.Role.*;

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

    public Optional<Member> findbyMemberId(String memberId) {
        return memberRepository.findbyMemberId(memberId);
    }

    public boolean existsMemberByMemberId(Long memberId) {
        return memberRepository.existsMemberByMemberId(memberId);
    }

    public boolean existsMemberByUsername(String username) {
        return memberRepository.findByUsername(username) != null;
    }

    public boolean register(RequestMemberDTO reginfo) {
        if (existsMemberByUsername(reginfo.getUsername())) {
            return false;
        }
        Member newMember = new Member(null,reginfo.getUsername(),
                reginfo.getPw(), USER.getValue(), LocalDateTime.now());
        memberRepository.save(newMember);
        return true;
    }

}
