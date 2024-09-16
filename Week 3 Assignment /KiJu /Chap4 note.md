
###  4장 스프링 부트 3와 테스트

# 4.1 테스트 코드 개념 익히기
---

- 테스트코드: 유지보수에 좋다. 코드 수정 시 기존 기능이 제대로 작동하지 않을까봐 걱정하지 않아도 된다. test 디렉토리에서 작업한다.


### 4.1.1 given-when-then 패턴
---
테스트코드를 3단계로 나누어 작성.

given -> 테스트 실행을 준비하는 단계
when -> 테스트를 진행하는 단계
then -> 테스트 결과를 검증하는 단계



# 4.2 스프링 부트 3와 테스트
---

### 4.2.1 스프링 부트 스타터 테스트 목록
---

JUnit -> 자바용 단위테스트 프레임워크.

테스트 방식을 구분할 수 있는 어노테이션 제공

@Test 어노테이션으로 메서드를 호출할때마다 새 인스턴스를 생성, 독립 테스트 가능

예상결과를 검증하는 어설션 메서드 제공

사용 방법이 단순, 테스트 코드 작성시간이 적음

자동 실행, 자체 결과를 확인하고 즉각적인 피드백을 제공


Spring Test & Spring Boot Test -> 스프링 부트 어플리케이션을 위한 통합테스트 지원

AssertJ -> 검증문 어설션을 작성하는데 쓰는 라이브러리

Hamcrest: 표현식을 이해하기 쉽게 만드는 데 사용되는 Matcher 라이브러리

Mockito: 테스트에 사용할 가짜 객체인 목 객체를 쉽게 만들고, 관리하고, 검증할 수 있게 지원하는 테스트 프레임 워크

JSONassert: JSON용 어설션 라이브러리

JsonPath: JSON 데이터에서 특정 데이터를 선택하고 검색하기 위한 라이브러리



### 4.2.2 Junit으로 단위 테스트 코드 만들기


@DisplayName -> 테스트 이름 명시.

@Test -> 테스트를 수행하는 메서드.

@BeforeAll -> 맨처음 1번만 실행. 한번만 실해되므로 static메서드로 선언

@BeforeEach -> 테스트 케이스 실행 전마다 실행. public메서드로 선언

@AfterAll -> 전체 테스트 마치고 1회만 실행. static메서드로 선언

@AfterEach -> 테스트 케잇 종료마다 실행.  public메서드로 선언



### 4.2.3 왜 @BeforeAll과 @AfterAll만 static 메서드로 선언해야하는가? (static 메서드는 무엇일까?)
---

왜냐하면 해당 메서드가 해당 클래스의 인스턴스가 생성되기전에 실해되어야하기 때문이다.

static 메서드는 다음과 같은 특징을 가진다

- 클래스의 인스턴스를 생성하지 않고도 실행할 수 있다.
- 클래스가 메모리에 로드될때 함께 로드되기 때문에 객체를 생성하지않고도 실행가능한 것이다.
- 클래스이름을 통해 직접 실행가능하다.


예시) 
Math.random()과 같이 Math 클래스의 인스턴스 생성없이도 메서드 실행가능하다.



### 4.2.4 AssertJ로 검증문 가독성 높이기
---

-> 가독성 안좋음 (기대값과 비교값 구분이 어려움)
Assertions.assertEquals(sum, a + b);


-> 가독성 좋음 (기대값과 비교값이 명확히보임)
assertThat(a + b).isEquaTo(sum);

### 4.2.5 AssertJ의 다양한 메서드
---
- isEqualTo() -> 같은지 검증
- isNotEqualTo() -> 다른지 검증
- contains() -> 값을 포함하는지 검증
- doesNotContain() -> 값을 포함하지 않는지 검증
- startsWith() -> ~로 시작하는 값인지 검증
- endWith() -> ~로끝나는 값인지 검증
- isEmpty() -> 비어있는 값인지 검증
- isNotEmpty() -> 비어있지 않은 값인지 검증
- isPositive() -> 양수인지 검증
- isNegative() -> 음수인지 검증
- isGreaterThan() -> 큰값인지 검증
- isLessThan -> 작은값인지 검증


사용예시1) -> name1이 name2와 같은지 확인
assertThat(name1).isEqualTo(name2);


사용예시2) -> 변수가 NULL이 아닌지 확인
assertThat(name1).isNotNull();

