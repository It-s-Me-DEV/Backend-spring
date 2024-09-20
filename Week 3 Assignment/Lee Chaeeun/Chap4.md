# 테스트 코드란? 
테스트 코드는 작성한 코드가 의도대로 잘 동작하고 예상치 못한 문제가 없는지 확인할 목적으로 작성하는 코드이다. 

## given-when-then 패턴
테스트 코드를 세 단계로 구분해 작성하는 방식이다.

given: 테스트 실행을 준비하는 단계
when: 테스트를 진행하는 단계
then: 테스트 결과를 검증하는 단계

# JUnit이란?
JUnit이란 자바 언어를 위한 단위 테스트 프레임워크이다.
여기서 단위 테스트란, 작성한 코드가 의도대로 작동하는지 작은 단위로 검증하는 것을 의미한다.
이때 단위는 보통 메서드가 된다.

## JUnit의 특징
테스트 방식을 구분할 수 있는 애너테이션을 제공
@Test 애너테이션으로 메서드를 호출할 때마다 새 인스턴스를 생성, 독립 테스트 가능
예상 결과를 검증하는 어설션(Assertions) 메서드 제공
사용 방법이 단순, 테스트 코드 작성 시간이 적음
자동 실행, 자체 결과를 확인하고 즉각적인 피드백을 제공

'''
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다") // 테스트 이름
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;
        Assertions.assertEquals(sum, a + b);
    }
}
'''

이 테스트에서는 Junit에서 제공하는 검증 메서드인 assertEquals()로 a + b와 sum의 값이 같은지 확인한다.
assertEquals() 메서드의 첫 번째 인수에는 기대하는 값, 두 번째 인수에는 실제로 검증할 값을 넣어준다. 

### @BeforeAll 애너테이션
전체 테스트를 실행하기 전에 한 번만 실행하며 메소드를 static로 선언한다.
### @BeforeEach 애너테이션
테스트 케이스를 시작하기 전에 매번 실행되며 메소드가 static가 아니여야 한다.
### @AfterAll 애너테이션
전체 테스트를 마치고 종료하기 전에 한 번만 실행하며 메소드를 static으로 선언해야 한다.
### @AfterEach 애너테이션
각 테스트 케이스를 종료하기 전 매번 실행하며 메소드가 static가 아니여야 한다.

'''
import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드를 static로 선언
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach // 테스트 케이스를 시작하기 전마다 실행
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll //전체 테스트를 종료하기 전에 1회 실행하므로 메서드를 static로 선언
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    @AfterEach // 테스트 케이스를 종료하기 전마다 실행
    public void afterEach() {
        System.out.println("@AfterEach");
    }
}
'''

## AssertJ로 검증문 가독성 높이기
AssertJ는 Junit과 함께 사용해 검증문의 가독성을 확 높여주는 라이브러리이다. 

 '''
 Assertions.assertEqualas(sum, a + b);
 '''
 이 코드의 Assertions은 기댓값과 실제 비굣값을 명시하지 않으므로 비교 대상이 헷갈린다.

 '''
 assertThat(a + b).isEqualTo(sum)
 '''
 이 코드는 AssertJ를 적용한 코드이다.
 이 경우 a와 b를 더한 값이 sum과 같아야 한다는 의미로 명확하게 읽히기 때문에 코드를 읽는 사람이 헷갈리지 않는다.



 
