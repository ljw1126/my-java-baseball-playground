package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OutputView {
    private static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public OutputView() {
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public int askContinue() {
        System.out.println(CONTINUE_MESSAGE);
        Scanner sc = new Scanner(System.in);

        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return askContinue();
        }
    }
}
