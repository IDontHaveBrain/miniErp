package minierp.web.domain.entity.member;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

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
    @Column(name = "username")
    private String userName;

    @NotNull
    @JsonIgnore
    private String pw;
    @NotNull
    private String roles;
    @NotNull
    private Date createdDate;

    public String getUserName() {
        return userName;
    }

    @JsonIgnore
    public List<String> getRolesList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        getRolesList().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r));
        });
        return authorities;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return getMemberId().toString();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return getPw();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        // 만료된 계정 체크
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        // 정지된(locked) 사용자 체크
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        // 인증기한 만료 체크
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        // 활성 사용자 체크
        return true;
    }
}
