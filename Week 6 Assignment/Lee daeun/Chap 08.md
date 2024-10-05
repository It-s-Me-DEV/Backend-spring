# 스프링 시큐리티로 로그인/로그아웃, 회원가입 구현하기
### 로그인 구조 이해하기
1. /login 요청이 들어올때 UserViewController가 분기 처리를 함
2. WebSecurityConfig에 설정한 보안 내용 실행
3. UserViewController가 분기 처리 후 UserDetailsService를 실행
4. 성공했을때 defaultSuccessUrl로 설정한 경로로 리다이렉트
5. UserDetailsService에서 loadUserByUsername() 메서드를 실행한 후 유저를 찾아 반환

### 로그아웃 구조 이해하기
1. UserApiController에서 로그아웃 실행
2. SecurityContextLogoutHander가 제공하는 logout()실행

### 스프링 시큐리티란?
: 스프링 기반의 애플리케이션 보안(인증, 인가, 권한)을 담당하는 스프링 하위 프레임워크

#### 인증과 인가
인증: 사용자의 신원을 입증하는 과정
인가: 사이트의 특정 부분에 접근할 수 있는 권한 확인

#### 스프링 시큐리티
: 스프링 기반 애플리케이션의 보안을 담당하는 스프링 하위 프레임워크로 CSRF 공격, 세션 고정 공격 방어의 역할을 해준다.
이때 스프링 시큐리티는 필터 기반으로 동작하는데 다양한 필터에서 인증, 인가 작업을 한다.
** 필터의 종류: SecurityContextPersistenceFilter ~ FilterSecurityInterceptor **
대표적인 필터)
1. UsernamePasswordAuthenticationfilter: 아이디와 패스워드가 넘어오면 인증 요청을 위임하는 인증 관리자 역할
2. FilterSecurityInterceptor: 권한 부여 처리를 위임해 접근 제어 결정을 쉽게 하는 접근 결정 관리자

### 로그인 과정
1. 사용자 아이디, 비밀번호 입력 -> http요청
2. AuthenticationFilter에서 넘어온 아이디와 비밀번호 유효성 검사
3. UsernamePasswordAuthenticationToken 만들어줌
4. Token을 AuthenticationManager에게 전송
5. Token을 provider에게 전송
6. 사용자 아이디를 UserDetailService에 전송한 후 사용자 아이디로 사용자 정보를 만들어 provider에게 전송
7. db에 있는 사용자의 정보와 비교해 실제인증 처리

### 회원 도메인 만들기
