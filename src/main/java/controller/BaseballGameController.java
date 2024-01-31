package controller;

import model.Balls;
import model.ResultData;
import utils.RandomBallNoGenerator;
import view.InputView;
import view.OutputView;

public class BaseballGameController {
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Balls computerBalls = new Balls(RandomBallNoGenerator.generateRandomBallNo());
        int answer = -1;
        while(answer != EXIT) {
            Balls userBalls = new Balls(inputView.askUserBalls());
            ResultData result = userBalls.match(computerBalls);

            outputView.printResult(result.toString());

            if(result.isGameEnd()) {
                answer = outputView.askContinue();
                computerBalls = reset(computerBalls, answer);
            }
        }
    }

    private Balls reset(Balls computerBalls, int answer) {
        if(answer == RESTART) {
            return new Balls(RandomBallNoGenerator.generateRandomBallNo());
        }

        return computerBalls;
    }
}
