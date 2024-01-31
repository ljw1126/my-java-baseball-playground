package model;

import java.util.Objects;

import static model.BallStatus.*;

public class ResultData {
    private static final int BALL_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    public ResultData() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public ResultData(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isNothing() {
        return this.strikeCount == 0 && this.ballCount == 0;
    }

    public void addResult(BallStatus ballStatus) {
        if(ballStatus.isStrike()) {
            this.strikeCount += 1;
        }

        if(ballStatus.isBall()) {
            this.ballCount += 1;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        if(this.strikeCount > 0) {
            sb.append(this.strikeCount).append(STRIKE.getName()).append(" ");
        }
        
        if(this.ballCount > 0) {
            sb.append(this.ballCount).append(BALL.getName()).append(" ");
        }
        
        if(isNothing()) {
            sb.append(NOTHING.getName());
        }
        
        return sb.toString();        
    }

    public boolean isGameEnd() {
        return this.strikeCount == BALL_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultData that = (ResultData) o;
        return strikeCount == that.strikeCount && ballCount == that.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
