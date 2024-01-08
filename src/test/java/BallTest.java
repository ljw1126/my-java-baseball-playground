import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    private Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(1, 1);
    }

    @DisplayName("위치와 볼 번호가 같으면 STRIKE 이다")
    @Test
    void strike() {
        Ball userBall = new Ball(1, 1);
        Assertions.assertThat(computerBall.play(userBall)).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("위치는 다른데, 볼 번호가 같으면 BALL 이다")
    @Test
    void ball() {
        Ball userBall = new Ball(2, 1);
        Assertions.assertThat(computerBall.play(userBall)).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("위치랑 볼 번호 둘 다 다르면 NOTHING 이다")
    @Test
    void nothing() {
        Ball userBall = new Ball(2, 2);
        Assertions.assertThat(computerBall.play(userBall)).isEqualTo(BallStatus.NOTHING);
    }
}