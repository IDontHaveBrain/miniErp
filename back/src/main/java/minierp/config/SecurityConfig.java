package minierp.config;

import minierp.jwt.JwtAccessDeniedHandler;
import minierp.jwt.JwtAuthenticationEntryPoint;
import minierp.jwt.JwtAuthenticationFilter;
import minierp.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static minierp.web.domain.entity.Role.*;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig implements WebMvcConfigurer {
    private final TokenProvider tokenProvider;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public SecurityConfig(TokenProvider tokenProvider, JwtAccessDeniedHandler jwtAccessDeniedHandler, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.tokenProvider = tokenProvider;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()

                // jwt 인증 예외 처리.
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)//인증 실패
                .accessDeniedHandler(jwtAccessDeniedHandler)//인가 실패
                .and()
                // jwt 인증 필터 등록.
                .addFilterBefore(new JwtAuthenticationFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
                // 세선 미사용 설정.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 권한 설정.
                .authorizeRequests()
                .antMatchers("/api/hello").hasRole(ADMIN.name())
                .antMatchers("/api/signin").permitAll()
                .antMatchers("/api/register").permitAll()
                .anyRequest().authenticated()
                .and()
                //
                .formLogin().disable()
                .httpBasic().disable();

        return http.build();
    }

    //cors 로컬 전체 승인
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .exposedHeaders("X-AUTH-TOKEN")
//                .allowCredentials(true)
                .allowedOrigins("http://localhost:3000");
    }
}
