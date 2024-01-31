package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {
    private List<Ball> ballList;

    public Balls(List<Integer> ballNumbers) {
        this.ballList = mapBallList(ballNumbers);
    }

    private static List<Ball> mapBallList(List<Integer> ballNumbers) {
        List<Ball> balls = new ArrayList<>();
        for(int i = 0; i < ballNumbers.size(); i++) {
            balls.add(new Ball(i + 1, ballNumbers.get(i)));
        }

        return balls;
    }

    public ResultData match(Balls otherBalls) {
        ResultData resultData = new ResultData();

        for(Ball ball : this.ballList) {
            resultData.addResult(otherBalls.judgement(ball));
        }

        return resultData;
    }

    private BallStatus judgement(Ball other) {
        return this.ballList.stream()
                .map(ball -> ball.compare(other))
                .filter(ballStatus -> !ballStatus.isNothing())
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls = (Balls) o;
        return Objects.equals(ballList, balls.ballList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballList);
    }
}
