package minierp.web.controller;

import jdk.jfr.Registered;
import minierp.web.domain.entity.member.Member;
import minierp.web.domain.entity.member.RequestMemberDTO;
import minierp.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<String> register(RequestMemberDTO reginfo){
        if (Stream.of(reginfo.getPw(), reginfo.getUsername())
                .anyMatch(s -> s == null || s.isBlank())) {
            System.out.println("필수 정보 미입력");
            return ResponseEntity.badRequest().body("필수 정보를 입력해주세요.");
        }
        System.out.println("ㅁㄴㅇㅁㄴㅇ");

        if(memberService.register(reginfo)) {
            return ResponseEntity.ok("회원가입 성공");
        }

        return ResponseEntity.badRequest().body("회원가입 실패");
    }
}
