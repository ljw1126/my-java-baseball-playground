package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("")
    @Test
    void split1() {
        String given = "1,2";
        String[] tokens = given.split(",");

        assertThat(tokens).contains("1", "2");
    }

    @DisplayName("")
    @Test
    void split2() {
        String given = "1";
        String[] tokens = given.split(",");

        assertThat(tokens).containsExactly("1");
    }

    @DisplayName("")
    @Test
    void substring() {
        String given = "(1,2)";
        given = given.substring(1);
        given = given.substring(0, given.length() - 1);

        String result  = "1,2";
        assertThat(given).isEqualTo(result);
    }

    @DisplayName("")
    @Test
    void charAt() {
        String given = "abc";

        assertThat(given.charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> given.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
