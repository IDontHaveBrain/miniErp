package minierp.web.domain.entity.member;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId; //사번

    @NotNull
    private String username;
    @NotNull
    private String pw;
    @NotNull
    private String roles;
    @NotNull
    private LocalDateTime createdDate;

    public List<String> getRolesList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        getRolesList().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return getPw();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 만료된 계정 체크
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 정지된(locked) 사용자 체크
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 인증기한 만료 체크
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 활성 사용자 체크
        return true;
    }
}
