package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LapCountTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(ints = {1,2,3,Integer.MAX_VALUE})
  @ParameterizedTest
  void constructionTest(int given) {
    assertThat(new LapCount(given)).isEqualTo(new LapCount(given));
  }

  @DisplayName("1 보다 작은 값이 들어오면 IllegalArgumentException")
  @ValueSource(ints = {0, -1, -2, Integer.MIN_VALUE})
  @ParameterizedTest
  void constructionFailWhenValueLessThanZeroTest(int given) {
    assertThatThrownBy(() -> new LapCount(given)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도할 회수(Lap 수)가 1 미만이 될 수 없습니다.");
  }

}
