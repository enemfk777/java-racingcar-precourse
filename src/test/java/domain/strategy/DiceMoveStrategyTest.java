package domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiceMoveStrategyTest {

  private static final int THRESHOLD = 4;

  @DisplayName("4 미만의 값에는 false 리턴한다.")
  @ValueSource(ints = {0, 1, 2, 3})
  @ParameterizedTest
  void isNotMovable(int given) {
    MoveStrategy dice = new DiceMoveStrategy(() -> given, THRESHOLD);
    assertThat(dice.isMovable()).isFalse();
  }

  @DisplayName("4 이상의 값에는 true 리턴한다.")
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  @ParameterizedTest
  void isMovable(int given) {
    MoveStrategy dice = new DiceMoveStrategy(() -> given, THRESHOLD);
    assertThat(dice.isMovable()).isTrue();
  }
}
