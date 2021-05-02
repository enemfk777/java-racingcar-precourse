package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DistanceTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(ints = {1, 2, 3, Integer.MAX_VALUE})
  @ParameterizedTest
  void constructionTest(int given) {
    assertThat(new Distance(given)).isEqualTo(new Distance(given));
  }

  @DisplayName("0 미만의 값이 입력되면 객체 생성 실패")
  @ValueSource(ints = {-1, -2, -3, Integer.MIN_VALUE})
  @ParameterizedTest
  void constructionFailByNullAndEmptySourceTest(int given) {
    assertThatThrownBy(() -> new Distance(given)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이동 거리가 0 미만이 될 수 없습니다.");
  }

}