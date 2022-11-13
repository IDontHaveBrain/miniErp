package minierp.web.domain.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId; //사번

    @NotNull
    private String pw;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role; //권한
}
