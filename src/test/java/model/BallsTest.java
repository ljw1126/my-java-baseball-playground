package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls computerBall = new Balls(Arrays.asList(1, 2, 3));

    @Test
    void equals() {
        Balls expectedBall = new Balls(Arrays.asList(1, 2, 3));
        assertThat(computerBall).isEqualTo(expectedBall);
    }

    @Test
    void nothing() {
        Balls userBall = new Balls(Arrays.asList(4, 5, 6));
        ResultData actual = userBall.match(computerBall);

        ResultData expected = new ResultData(0, 0);

        assertThat(actual.isNothing()).isTrue();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void result_3strike() {
        Balls userBall = new Balls(Arrays.asList(1, 2, 3));
        ResultData actual = userBall.match(computerBall);

        ResultData expected = new ResultData(3, 0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void result_3ball() {
        Balls userBall = new Balls(Arrays.asList(2, 3, 1));
        ResultData actual = userBall.match(computerBall);

        ResultData expected = new ResultData(0, 3);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void result_1strike_2ball() {
        Balls userBall = new Balls(Arrays.asList(3, 2, 1));
        ResultData actual = userBall.match(computerBall);

        ResultData expected = new ResultData(1, 2);

        assertThat(actual).isEqualTo(expected);
    }

}