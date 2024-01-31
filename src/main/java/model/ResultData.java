package model;

import java.util.Objects;

public class ResultData {
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
