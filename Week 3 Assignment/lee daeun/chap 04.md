## Chap 04. 스프링 부트3와 테스트
**핵심 키워드** : Junit, AssertJ, @Test, given-when-then

### 4.1 테스트 코드란?
: 테스트 코드란 코드가 의도대로 잘 동작하고 문제가 없는지 확인하기 위해 작성하는 코드로 유지보수에 사용되며 코드 수정 시 기존 기능이 제대로 작동하지 않는 문제를 방지한다.
**테스트 코드는 test 디렉터리에서 작업한다.**
>given-when-then 패턴
>코드를 세 단계로 구분해 작성한다.

> 1. given은 테스트 실행을 준비하는 단계

> 2. when은 테스트를 진행하는 단계

> 3. then은 테스트 결과를 검증하는 단계

### 4.2 스프링 부트3와 테스트
:spring-boot-starter-test 스타터에 테스트를 위한 도구거 모여있다.
>JUnit 이란?
> 자바 언어를 위한 단위 테스트 프레임워크로 단위 테스트란 작성한 코드가 의도대로 작동하는지 작은 단위로 검증하는 것을 의미한다.

### Junit으로 단위 테스트 코드 만들어 보기 <실습>

테스트가 성공하는 경우


<img width="465" alt="스크린샷 2024-09-21 오후 9 33 40" src="https://github.com/user-attachments/assets/507fe900-d901-4f30-b4d8-32ab5cd79bbc">

<img width="280" alt="스크린샷 2024-09-21 오후 9 35 18" src="https://github.com/user-attachments/assets/aa8ab84a-5aca-4c07-b151-9a3fd358e98d">

테스트가 실패하는 경우

<img width="403" alt="스크린샷 2024-09-21 오후 9 35 32" src="https://github.com/user-attachments/assets/4750252c-8b8c-41ab-ad58-448a7dfae588">

<img width="288" alt="스크린샷 2024-09-21 오후 9 35 45" src="https://github.com/user-attachments/assets/1a229ff2-fda6-4c56-93f0-c51b1a1d0029">

<JUnitCycleTest.java>

<img width="254" alt="스크린샷 2024-09-21 오후 9 42 26" src="https://github.com/user-attachments/assets/6ac0c437-460c-49d1-b7b1-b36eb16b47e5">

**애너테이션**
1). @BeforeAll 애너테이션
:

2). @BeforeEach 애너테이션
:

3). @AfterAll 애너테이션
:

4). @AfterEach 애너테이션
:

