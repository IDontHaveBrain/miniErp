package minierp.web.domain.entity;


import lombok.*;
import minierp.web.domain.entity.member.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vacationId; //연차키값

    @OneToOne(targetEntity = Approval.class)
    @JoinColumn(name="approval_id")
    private Long approvalId; //결재키값

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name="member_id")
    private String memberId;

    @NotNull
    private String useDay;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;

}
