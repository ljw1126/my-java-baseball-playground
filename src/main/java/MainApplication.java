import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApplication {

    private static final int STRIKE_CNT = 3;

    public static void main(String[] args) {
        Balls computer = new Balls(generateRandomNumber());

        int strikeCount = 0;
        while(strikeCount != STRIKE_CNT) {
            PlayResult playResult = computer.play(askNumber());
            strikeCount = playResult.getStrike();

            System.out.println(playResult.getResult());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static List<Integer> askNumber() {
        System.out.println("숫자를 입력해 주세요 :");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        List<Integer> userBall = new ArrayList<>();
        for(String no : input.split("")) {
            userBall.add(Integer.parseInt(no));
        }

        return userBall;
    }

    public static List<Integer> generateRandomNumber() {
        return new Random().ints(1, 10)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }
}
