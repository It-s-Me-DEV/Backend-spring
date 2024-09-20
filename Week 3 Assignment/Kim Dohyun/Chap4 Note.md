# 04장 스프링 부트 3와 테스트
## 테스트 코드 개념
### 테스트 코드란
목적: 작성한 코드가 의도대로 작동하는지, 예상치 못한 문제가 없는지 확인할 목적으로 작성하는 코드.
유지보수, 수정이 용이함

test 디렉터리에서 작업

### 테스트 코드의 패턴
#### - given-when-then 패턴:
given: 테스트 실행 준비 단계
when: 테스트 진행 단계
then: 테스트 결과 검증

## 테스트 도구
spring-boot-starter-test 스타터에 테스트를 위한 도구가 모여있다.
### JUnit: 자바 언어를 위한 단위 테스트 프레임워크
  *단위 테스트: 코드의 검증을 위해 작은 단위로 테스트 하는 것.

 #### 테스트 방식을 구분할 수 있는 애너테이션 제공.
  @BeforeAll: 테스트 시작 전에 한 번 실행.
  @BeforeEach: 각 테스트 전에 실행.
  @Test: 실제 테스트 메서드.
  @AfterEach: 각 테스트 후에 실행.
  @AfterAll: 모든 테스트 완료 후에 한 번 실행.
 #### 독립적인 테스트 가능.
  @Test 애너테이션으로 새 인스턴스가 생성되어 독립적으로 실행됨 
 #### 예상 결과를 검증하는 어설션 메서드 제공.
 
### AssertJ: 검증문을 작성하는 데 사용되어 가독성을 높임.



