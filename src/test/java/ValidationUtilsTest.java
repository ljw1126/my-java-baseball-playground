import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationUtilsTest {

    @DisplayName("0은 유효한 값이 아니다")
    @Test
    void invalidRange() {
        assertThat(ValidationUtils.validNo(0)).isFalse();
    }

    @DisplayName("1~9 사이의 유효한 값은 true 반환한다")
    @Test
    void validRange() {
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(5)).isTrue();
        assertThat(ValidationUtils.validNo(9)).isTrue();
    }

}