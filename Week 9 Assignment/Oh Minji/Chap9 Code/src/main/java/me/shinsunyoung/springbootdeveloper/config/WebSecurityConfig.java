package me.shinsunyoung.springbootdeveloper.config;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.service.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig { // 시큐리티 설정

    private final UserDetailService userService;

    @Bean
    public WebSecurityCustomizer configure() { // 정적 리소스에서는 시큐리티의 인증, 인가 서비스를 사용하지 않도록 비활성화 시킴
        return (web) -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers(new AntPathRequestMatcher("/static/**"));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 특정 http 요청에 대한 웹 기반 보안 구성
        return http
                .authorizeRequests(auth -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/login"),
                                new AntPathRequestMatcher("/signup"),
                                new AntPathRequestMatcher("/user")
                        ).permitAll() // /login, /signup, /user 요청이 오면 인증, 인가 없이 모두가 접근
                        .anyRequest().authenticated()) // 그 외 요청에 대해 인증이 성공되어야 접근 가능
                .formLogin(formLogin -> formLogin // 폼 기반 로그인 설정
                        .loginPage("/login") // 로그인 페이지 경로 설정
                        .defaultSuccessUrl("/articles") // 로그인 완료 시 이동 경로 설정
                )
                .logout(logout -> logout // 로그아웃 설정
                        .logoutSuccessUrl("/login") // 로그아웃 완료 시 이동 경로 설정
                        .invalidateHttpSession(true) // 로그아웃 후 세션 전체 삭제
                )
                .csrf(AbstractHttpConfigurer::disable) // 실습 편리성을 위해 csrf 설정 비활성화 (공격을 방지하기 위해서는 활성화 해두는 것이 좋음)
                .build();
    }

    @Bean // 인증 관리자 관련 설정
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService); // 사용자 정보를 가져올 서비스를 설정
        authProvider.setPasswordEncoder(bCryptPasswordEncoder); // 비밀번호 암호화를 위한 인코더 설정
        return new ProviderManager(authProvider);
    }

    @Bean // 패스워드 인코더로 사용할 빈 설정
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
