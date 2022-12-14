package minierp.web.controller;


import lombok.RequiredArgsConstructor;
import minierp.web.domain.entity.member.RequestMemberDTO;
import minierp.web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ErpController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/join")
    public RequestMemberDTO join(@RequestBody RequestMemberDTO member) {
        return memberService.join(member);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }


}
