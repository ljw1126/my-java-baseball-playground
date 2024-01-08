public class PlayResult {
    private int strike;
    private int ball;

    public PlayResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public void report(BallStatus ballStatus) {
        if(ballStatus.isStrike()) {
            strike += 1;
            return;
        }

        if(ballStatus.isBall()) {
            ball += 1;
        }
    }

    public String getResult() {
        if(strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if(strike != 0) {
            sb.append(strike).append(" 스트라이크 ");
        }

        if(ball != 0) {
            sb.append(ball).append( " 볼 ");
        }

        return sb.toString();
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return ball;
    }
}
