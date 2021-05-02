package domain;

import domain.strategy.MoveStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

  private static List<String> FIRST_GIVEN_NAMES;
  private static List<String> SECOND_GIVEN_NAMES;

  private static List<RunResult> FIRST_GIVEN_RESULTS;
  private static List<RunResult> SECOND_GIVEN_RESULTS;
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

    RunResult zeroResult = new RunResult(new CarName(zero), new Distance(1));
    RunResult oneResult = new RunResult(new CarName(one), new Distance(1));
    RunResult twoResult = new RunResult(new CarName(two), new Distance(1));
    RunResult threeResult = new RunResult(new CarName(three), new Distance(1));
    RunResult fourResult = new RunResult(new CarName(four), new Distance(1));
    RunResult fiveResult = new RunResult(new CarName(five), new Distance(1));
    FIRST_GIVEN_RESULTS = List.of(oneResult, zeroResult, twoResult);
    SECOND_GIVEN_RESULTS = List.of(threeResult, fourResult, fiveResult);
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertAll(() -> assertThat(RacingCars.fromAttendeeNamesWithMoveStrategy(FIRST_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY))
                            .isEqualTo(RacingCars.fromAttendeeNamesWithMoveStrategy(FIRST_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY)),
              () -> assertThat(RacingCars.fromAttendeeNamesWithMoveStrategy(SECOND_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY))
                            .isEqualTo(RacingCars.fromAttendeeNamesWithMoveStrategy(SECOND_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY))
    );
  }

  @DisplayName("중복 된 이름의 참가자가 있으면 IllegalArgumentExeption")
  @Test
  void constructionFailTest() {
    List<String> givenAttendee = List.of("dup", "dup", "unique");
    assertThatThrownBy(() -> RacingCars.fromAttendeeNamesWithMoveStrategy(givenAttendee, ALWAYS_TRUE_STRATEGY)).isInstanceOf(IllegalArgumentException.class)
                      .hasMessageContaining("같은 이름의 참여자가 있습니다. 참여자의 이름은 모두 달라야 합니다.");
  }

  @DisplayName("raceOneLap 메서드 실행 시 Lap 한바퀴를 끝낸 결과를 참여자 순서대로 정렬된 채 LapResult 객체로 반환")
  @Test
  void raceOneLapTest() {
    assertAll(() -> assertThat(RacingCars.fromAttendeeNamesWithMoveStrategy(FIRST_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY).raceOneLap())
                            .isEqualTo(new LapResult(FIRST_GIVEN_RESULTS)),
              () -> assertThat(RacingCars.fromAttendeeNamesWithMoveStrategy(SECOND_GIVEN_NAMES, ALWAYS_TRUE_STRATEGY).raceOneLap())
                            .isNotEqualTo(new LapResult(SECOND_GIVEN_RESULTS))
    );
  }
}