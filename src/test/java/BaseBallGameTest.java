import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameTest {

    @DisplayName("1 ~ 9 숫자 중에서 중복 없이 3개를 랜덤으로 뽑아 문자열로 리턴한다")
    @Test
    void getRandomNumber() {
        for(int i = 1; i < 999; i++) {
            int given = Integer.parseInt(BaseBallGame.getRandomNumber());
            assertThat(given).isBetween(1, 987);
        }
    }

    @DisplayName("")
    @Test
    void getResult() {
        String actual = "123";
        String expected = "321";

        Map<String, Integer> resultMap = BaseBallGame.getResult(actual, expected);
        assertThat(resultMap).containsEntry("볼", 2).containsEntry("스트라이크", 1);
    }

    @Test
    void getResult2() {
        String actual = "123";
        String expected = "456";

        Map<String, Integer> resultMap = BaseBallGame.getResult(actual, expected);
        assertThat(resultMap).isEmpty();
    }
}