package domain;

import domain.strategy.MoveStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

  private static List<String> FIRST_GIVEN_NAMES;
  private static List<String> SECOND_GIVEN_NAMES;
  private static MoveStrategy ALWAYS_TRUE_STRATEGY = () -> true;

  @BeforeAll
  static void setUp() {
    String zero = "zero";
    String one = "one";
    String two = "two";
    String three = "three";
    String four = "one";
    String five = "one";
    FIRST_GIVEN_NAMES = List.of(one, zero, two);
    SECOND_GIVEN_NAMES = List.of(four, three, five);
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertAll(() -> assertThat(RacingCars.fromParticipationNamesWithMoveStrategy(FIRST_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY))
                            .isEqualTo(RacingCars.fromParticipationNamesWithMoveStrategy(FIRST_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY)),
              () -> assertThat(RacingCars.fromParticipationNamesWithMoveStrategy(SECOND_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY))
                            .isEqualTo(RacingCars.fromParticipationNamesWithMoveStrategy(SECOND_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY))
    );
  }

}
