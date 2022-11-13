package minierp.web.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
