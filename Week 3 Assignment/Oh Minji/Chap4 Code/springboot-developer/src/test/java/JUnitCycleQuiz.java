import org.junit.jupiter.api.*;

public class JUnitCycleQuiz {
    @BeforeEach
    public void beforeEach() {
        System.out.println("Hello!");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("Bye!");
    }
    @Test
    public void test1() {
        System.out.println("This is first test");
    }
    @Test
    public void test2() {
        System.out.println("This is second test");
    }
}
