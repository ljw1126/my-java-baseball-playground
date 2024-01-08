import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.util.stream.Collectors.joining;

public class BaseBallGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String actual = getRandomNumber();

        String next = "";
        while(!"2".equals(next)) {
            System.out.println("숫자를 입력해 주세요 : ");
            StringBuilder sb = new StringBuilder();
            String expected = br.readLine();

            // 비교 해서 출력
            Map<String, Integer> resultMap = getResult(actual, expected);

            if(resultMap.isEmpty()) {
                System.out.println("낫싱");
                continue;
            }

            if(resultMap.getOrDefault("스트라이크", 0) == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

                next = br.readLine();
                continue;
            }

            for(String key : resultMap.keySet()) {
                sb.append(resultMap.get(key)).append(key).append(" ");
            }

            System.out.println(sb);
        }
    }

    public static Map<String, Integer> getResult(String actual, String expected) {
        Map<String, Integer> resultMap = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            if(expected.charAt(i) == actual.charAt(i)) {
                resultMap.put("스트라이크", resultMap.getOrDefault("스트라이크", 0) + 1);
                continue;
            }

            if(actual.indexOf(expected.charAt(i)) != -1) {
                resultMap.put("볼", resultMap.getOrDefault("볼", 0) + 1);
            }
        }

        return resultMap;
    }

    public static String getRandomNumber() {
        return new Random()
                .ints(1, 9)
                .distinct()
                .limit(3)
                .boxed()
                .map(String::valueOf)
                .collect(joining(""));
    }
}
