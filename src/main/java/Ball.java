import java.util.Objects;

/**
 * 볼의 (위치, 숫자) 비교
 * ex) (1, 1), (1, 2)
 */
public class Ball {
    private int ballIdx;
    private int ballNo;

    public Ball(int ballIdx, int ballNo) {
        this.ballIdx = ballIdx;
        this.ballNo = ballNo;
    }

    public BallStatus play(Ball ball) {
        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if(this.sameBallNo(ball.ballNo)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean sameBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballIdx == ball.ballIdx && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballIdx, ballNo);
    }
}
