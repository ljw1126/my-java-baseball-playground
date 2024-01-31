package utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomBallNoGenerator {
    public static List<Integer> generateRandomBallNo() {
        return new Random()
                .ints(1, 10)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }
}
