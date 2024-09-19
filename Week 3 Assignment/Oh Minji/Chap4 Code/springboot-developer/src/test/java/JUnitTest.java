import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다") // 테스트 이름을 명시
    @Test //테스트를 수행하는 메서드가 됨
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        Assertions.assertEquals(sum, a + b); // 첫번째 인수에는 기대하는 값, 두번쩨 인수에는 실제로 검증할 값
    }
}
