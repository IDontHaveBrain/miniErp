package minierp.web.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    SUPER_ADMIN("ROLE_SUPER_ADMIN,ROLE_ADMIN,ROLE_USER"),
    ADMIN("ROLE_ADMIN,ROLE_USER"),
    USER("ROLE_USER");

    private String value;
}
