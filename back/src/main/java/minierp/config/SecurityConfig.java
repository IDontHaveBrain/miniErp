package minierp.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static minierp.web.domain.entity.Role.*;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and()
                .authorizeRequests()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/api/join").permitAll()
                .antMatchers("/api/allinfo").hasAnyRole(SUPER_ADMIN.name(), ADMIN.name())
                .antMatchers("/api/myinfo").hasAnyRole(SUPER_ADMIN.name(), ADMIN.name(), USER.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("member_Id")
                .passwordParameter("pw")
                .defaultSuccessUrl("/api/admin", true)
                .and()
                .logout()
                .logoutSuccessUrl("/login");

        return http.build();
    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/api/hello").permitAll()
//                .antMatchers("/api/Hello").permitAll()
//                .anyRequest().authenticated();
//        return http.build();
//    }
}
