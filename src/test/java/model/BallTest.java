package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    private Ball computer = new Ball(1, 1);

    @Test
    void strike() {
        Ball user = new Ball(1, 1);
        assertThat(user.compare(computer)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball user = new Ball(2, 1);
        assertThat(user.compare(computer)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball user = new Ball(2, 3);
        assertThat(user.compare(computer)).isEqualTo(BallStatus.NOTHING);
    }
}