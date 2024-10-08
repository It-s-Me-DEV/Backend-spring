### 스프링 시큐리티
보안을 담당하는 스ㅡㅍ링 하위 프레임워크. 

#### 인증
사용자의 신원을 확인

#### 인가
사이트의 특정 부분에 접근할 수 있는지 권한을 확인하는 작업

#### 동작 방식
1. HTTPServletRequest에 아이디와 비밀번호 정보가 전달된다.
2. AuthenticationFilter가 넘어온 아이디와 비밀번호에 대해서 유효성 검사 진행
3. UsernamePasswordAuthenticationToken을 만들어서 넘겨준다
4. UsernamePasswordAuthenticationToken을 AuthenticationManager에게 보낸다
5. 또 이거를 AuthenticationProvider에게 보낸다.
6. 아이디를 UserDetailService로 보낸다
7. UserDetails객체가 AuthenticationProvider에게 전달됨
8. 디비에 사용자 정보를 가져온다
9. 정보를 비교
10. Security ContextHolder에 Authentication을 저장 
11. 성공하면 AuthenticationSuccessHandler, AuthenticationFailureHAndler 실행
