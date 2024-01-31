package utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBallNoGeneratorTest {

    @Test
    void 볼번호는_중복없이_3개가되야한다() {
        List<Integer> randomBallNo = RandomBallNoGenerator.generateRandomBallNo();
        assertThat(new HashSet<>(randomBallNo)).hasSize(3);
    }

    @Test
    void 각볼번호는_1에서_9사이_숫자이다() {
        for(int i = 0; i < 100; i++) {
            List<Integer> randomBallNo = RandomBallNoGenerator.generateRandomBallNo();
            for (int ballNo : randomBallNo) {
                assertThat(ballNo).isBetween(1, 10);
            }
        }
    }
}