import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 클래스 레벨 설정
    static void beforeAll() { // 전체 테스트를 시작하기 전에 1회 실행하므로 메서드는 static으로 선언
        System.out.println("@BeforeALl");
    }

    @BeforeEach // 메서드 레벨 설정; 테스트 개수만큼 반복
    public void beforeEach() { //테스트 케이스를 시작하기 전마다 실행
        System.out.println("@BeforeEach");
    }

    @Test // 테스트 실행
    public void test1() {
        System.out.println("test1");
    }

    @Test // 테스트 실행
    public void test2() {
        System.out.println("test2");
    }

    @Test // 테스트 실행
    public void test3() {
        System.out.println("test3");
    }

    @AfterAll // 메서드 레벨 정리; 테스트 개수만큼 반복
    static void afterAll() { // 전체 테스트를 마치고 종료하기 전에 1회 실행하므로 메서드는 static으로 선언
        System.out.println("@AfterAll");
    }

    @AfterEach // 클래스 레벨 정리
    public void afterEach() { // 테스트 케이스를 종료하기 전마다 실행
        System.out.println("@AfterEach");
    }
}
