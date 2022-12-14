package minierp.web.domain.entity.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestMemberDTO {

    private Long memberId;
    private String username;
    private String pw;
    private String roles;
}
