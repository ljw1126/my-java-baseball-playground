import java.util.ArrayList;
import java.util.List;

/**
 * 볼이 아래와 같이 주어질 때 판정하는 클래스 기능 구현
 * (1, 2, 3) , (1, 2, 3)
 */
public class Balls {

    private final List<Ball> answers;

    public Balls(List<Integer> computerBall) {
        this.answers = mapBalls(computerBall);
    }

    private static List<Ball> mapBalls(List<Integer> computerBall) {
        List<Ball> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            answer.add(new Ball(i, computerBall.get(i)));
        }
        return answer;
    }

    public PlayResult play(List<Integer> balls) {
        List<Ball> userBall = mapBalls(balls);
        PlayResult result = new PlayResult();

        for(Ball ball : userBall) {
            result.report(this.compareTo(ball));
        }

        return result;
    }

    private BallStatus compareTo(Ball ball) {
        return answers.stream()
                .map(answer -> answer.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
