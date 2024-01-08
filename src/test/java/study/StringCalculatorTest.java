package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @DisplayName("")
    @Test
    void nextLine() throws IOException {
        Scanner scanner = new Scanner("2 + 3 * 4 / 2");
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int result = Integer.parseInt(values[0]);
        for(int i = 2; i < values.length; i += 2) {
            int num = Integer.parseInt(values[i]);
            switch (values[i - 1]) {
                case "+" : result += num; break;
                case "-" : result -= num; break;
                case "/" : result /= num; break;
                case "*" : result *= num; break;
            }
        }

        assertThat(result).isEqualTo(10);
    }
}
