package minierp.web.service;

import minierp.web.domain.entity.member.Member;
import minierp.web.domain.entity.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        System.out.println("memberId = " + memberId);
        Optional<Member> member = memberRepository.findbyMemberId(memberId);
        if (member.isPresent()) {

            Member authMember = member.get();
            authMember.setPw(passwordEncoder.encode(authMember.getPw()));

            return authMember;
        }
        return null;
    }

}
