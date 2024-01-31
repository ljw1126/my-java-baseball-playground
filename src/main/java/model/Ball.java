package model;

import java.util.Objects;

import static model.BallStatus.*;

public class Ball {
    private int position;
    private int ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public BallStatus compare(Ball other) {
        if(this.equals(other)) {
            return STRIKE;
        }

        if(isSameBallNo(other)) {
            return BALL;
        }

        return NOTHING;
    }

    private boolean isSameBallNo(Ball other) {
        return this.ballNo == other.ballNo;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNo);
    }
}
