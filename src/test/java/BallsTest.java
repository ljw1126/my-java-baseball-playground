import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {
    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_3strike() {
        PlayResult result = balls.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
    }

    @Test
    void play_1strike_2ball() {
        PlayResult result = balls.play(Arrays.asList(1, 3, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void play_3ball() {
        PlayResult result = balls.play(Arrays.asList(3, 1, 2));
        assertThat(result.getBall()).isEqualTo(3);
    }


    @Test
    void nothing() {
        PlayResult result = balls.play(Arrays.asList(4, 5, 6));
        assertThat(result.getResult()).isEqualTo("낫싱");
    }
}