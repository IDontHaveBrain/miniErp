package minierp.web.controller;


import lombok.extern.slf4j.Slf4j;
import minierp.jwt.JwtAuthenticationFilter;
import minierp.web.domain.entity.member.CurrentUser;
import minierp.web.domain.entity.member.Member;
import minierp.web.domain.entity.member.RequestLoginDTO;
import minierp.web.domain.entity.member.RequestMemberDTO;
import minierp.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
public class ErpController {

    @Autowired
    private MemberService memberService;

    //@PostMapping("/join")
    @RequestMapping("/join")
    public RequestMemberDTO join(RequestMemberDTO member) {
        return memberService.join(member);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("admin");
    }

    @GetMapping("/myinfo")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Member myinfo(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member userDetails = (Member)principal;
        return userDetails;
    }

    @GetMapping("/allinfo")
    @Secured("ROLE_ADMIN")
    public List<Member> allinfo(@CurrentUser Member member){
        log.info("member : {}", member.toString());
        List<Member> allMember = memberService.getAllMember();
        return allMember;
    }

//    @CrossOrigin
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody(required = false) RequestMemberDTO member){
        log.info("username = {}, pw = {}", member.getUsername(), member.getPw());
        String jwt = memberService.login(member);

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtAuthenticationFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(jwt, headers, HttpStatus.OK);
    }
}
