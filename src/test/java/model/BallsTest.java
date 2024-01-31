package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls computerBall = new Balls(Arrays.asList(1, 2, 3));

    @Test
    void equals() {
        Balls expectedBall = new Balls(Arrays.asList(1, 2, 3));
        assertThat(computerBall).isEqualTo(expectedBall);
    }

    @ParameterizedTest
    @MethodSource("getBallsTestDataProvider")
    void ballsMatchTest(List<Integer> givenBallList, ResultData expected) {
        Balls userBall = new Balls(givenBallList);
        ResultData actual = userBall.match(computerBall);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> getBallsTestDataProvider() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(4, 5, 6), new ResultData(0, 0)),
                Arguments.arguments(Arrays.asList(1, 2, 3), new ResultData(3, 0)),
                Arguments.arguments(Arrays.asList(2, 3, 1), new ResultData(0, 3)),
                Arguments.arguments(Arrays.asList(3, 2, 1), new ResultData(1, 2))
        );
    }

}