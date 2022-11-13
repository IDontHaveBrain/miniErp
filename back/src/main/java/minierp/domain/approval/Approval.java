package minierp.domain.approval;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long approvalId;
    @NotNull
    private String process;


}
