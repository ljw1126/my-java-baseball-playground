package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해 주세요 :";
    private static final int BALL_COUNT = 3;
    private static final String INPUT_DELIMITER = "";
    public InputView() {
    }

    public List<Integer> askUserBalls() {
        System.out.print(USER_INPUT_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return parse(sc);
    }

    private List<Integer> parse(Scanner sc) {
        try {
            List<Integer> userBallNumberList = getUserBallNumberList(sc);

            checkBallNumberSize(userBallNumberList);

            return userBallNumberList;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askUserBalls();
        }
    }

    private static void checkBallNumberSize(List<Integer> userBallNumberList) {
        if(new HashSet<>(userBallNumberList).size() != BALL_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> getUserBallNumberList(Scanner sc) {
        String input = sc.next();
        String[] tokens = input.split(INPUT_DELIMITER);

        List<Integer> result = new ArrayList<>();
        for(String no : tokens) {
            result.add(Integer.valueOf(no));
        }

        return result;
    }
}
