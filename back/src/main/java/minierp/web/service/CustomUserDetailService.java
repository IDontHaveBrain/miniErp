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
        Optional<Member> member = memberRepository.findbyMemberId(memberId);
        /*
        if (member.isPresent()) {

            Member authMember = member.get();
            authMember.setPw(passwordEncoder.encode(authMember.getPw()));

            return authMember;
        }
         */
        member.ifPresentOrElse(
                authMember -> authMember.setPw(passwordEncoder.encode(authMember.getPw())),
                () -> { throw new UsernameNotFoundException("User not found");}
        );
        return member.get();
    }
}