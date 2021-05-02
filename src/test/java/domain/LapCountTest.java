package domain;

import domain.strategy.MoveStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LapCountTest {

  private static RacingCars GIVEN_CARS;
  private static RacingResult GIVEN_RESULTS;
  private static MoveStrategy ALWAYS_TRUE_STRATEGY = () -> true;

  @BeforeAll
  static void setUp() {
    String zero = "zero";
    String one = "one";
    String two = "two";
    Set<String> firstAttendeeNames = new LinkedHashSet<>(List.of(one, zero, two));
    GIVEN_CARS = RacingCars.fromAttendeeNamesWithMoveStrategy(firstAttendeeNames, ALWAYS_TRUE_STRATEGY);

    RunResult firstZeroResult = new RunResult(new CarName(zero), new Distance(1));
    RunResult firstOneResult = new RunResult(new CarName(one), new Distance(1));
    RunResult firstTwoResult = new RunResult(new CarName(two), new Distance(1));

    RunResult secondZeroResult = new RunResult(new CarName(zero), new Distance(2));
    RunResult secondOneResult = new RunResult(new CarName(one), new Distance(2));
    RunResult secondTwoResult = new RunResult(new CarName(two), new Distance(2));
    LapResult firstResult = new LapResult(List.of(firstOneResult, firstZeroResult, firstTwoResult));
    LapResult secondResult = new LapResult(List.of(secondOneResult, secondZeroResult, secondTwoResult));
    GIVEN_RESULTS = new RacingResult(List.of(firstResult, secondResult));
  }


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

  @DisplayName("LapCount 숫자 만큼 Lap 진행 후 RaceResult 반환")
  @Test
  void raceEachLapsTest() {
    LapCount givenLapCount = new LapCount(2);
    assertThat(givenLapCount.raceEachLaps(GIVEN_CARS)).isEqualTo(GIVEN_RESULTS);
  }
}
