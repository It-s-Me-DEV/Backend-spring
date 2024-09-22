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
: 전체 테스트 전 한 번만 실행되는데, 데이터베이스를 연결하거나 테스트 환경을 초기화 할 때 사용된다. 이때 한 번만 호출 되어야 하므로 static으로 선언한다.

2). @BeforeEach 애너테이션
: 테스트 케이스를 실행할 때 매번 실행되는데, 객체를 초기화하거나 테스트에 필요한 값을 미리 넣을 때 사용된다. 이때 매번 호출해야 하므로 static 으로 선언하면 안됨

3). @AfterAll 애너테이션
: 전체 테스트를 종료하기 전 한번만 실행, 데이터베이스 연결을 종료하거나 공통적으로 사용하는 자원을 해재할때 사용된다. 전체 주기에 한번만 호출되므로 static으로 선언

4). @AfterEach 애너테이션
: 각 테스트 케이스를 종료하기 전 매번 실행, 특정 테이터를 삭제할때 사용 static이면 안됨

**@BeforeAll -> @BeforeEach -> @Test -> @AfterEach -> @AfterAll**

<img width="414" alt="스크린샷 2024-09-22 오후 5 24 56" src="https://github.com/user-attachments/assets/a862ad24-332e-444e-a66f-0f1a5255d4e9">

### AssertJ로 검증문 가독성 높이기
: 검증문의 가독성을 높여주는 라이브러리로 명확하게 읽히는 코드로 헷갈리지 않게 도와준다

**각각의 테스트를 시작하기 전에 "Hello!"를 출력하는 메서드와 모든 테스트를 끝마치고 "Bye"를 출력하는 메서드를 추가하세요**

<img width="604" alt="스크린샷 2024-09-22 오후 5 37 01" src="https://github.com/user-attachments/assets/45e6a197-041f-46ea-8616-8d9ce49c67d0">

**Given-When-Then 패턴**

>1). Given : 멤버를 저장한다.

>2). When : 멤버 리스트를 조회하는 API를 호출한다.

>3). Then : 응답코드가 200 OK이고, 반환받은 값 중에 0번째 요소의 id와 name이 저장된 값과 같은지 확인한다.

```
Code code = new Code(13)
objectMapper.writeValueAsString(code)
```
-> ObjectMapper은 Jackson 라이브러리에서 제공하는 클래스로 객체와 JSON간의 변환을 처리해준다. new Code(13)과 같이 객체로 만들고 writeValueAsString(code)와 같이 매서드를 호출하면 JSON 형태로 문자열 객체가 변환된다.<객체 직렬화>

-> {'value':13}의 형태로 출력

