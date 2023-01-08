package minierp.web.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    SUPERADMIN("ROLE_SUPERADMIN"),
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;
}
