package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResultTest {

  private static List<LapResult> GIVEN_LAP_RESULTS;

  @BeforeAll
  static void setUp() {
    RunResult zeroFirstLap = new RunResult(new CarName("zero"), new Distance(0));
    RunResult oneFirstLap = new RunResult(new CarName("one"), new Distance(1));
    RunResult twoFirstLap = new RunResult(new CarName("two"), new Distance(2));
    RunResult zeroSecondLap = new RunResult(new CarName("zero"), new Distance(1));
    RunResult oneSecondLap = new RunResult(new CarName("one"), new Distance(1));
    RunResult twoSecondLap = new RunResult(new CarName("two"), new Distance(3));

    LapResult firstLapResult = new LapResult(List.of(zeroFirstLap, oneFirstLap, twoFirstLap));
    LapResult secondLapResult = new LapResult(List.of(zeroSecondLap, oneSecondLap, twoSecondLap));
    GIVEN_LAP_RESULTS = List.of(firstLapResult, secondLapResult);
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertThat(new RacingResult(GIVEN_LAP_RESULTS)).isEqualTo(new RacingResult(GIVEN_LAP_RESULTS));
  }

  @DisplayName("마지막 Lap에서 가장 멀리 위치한 참여자들의 이름을 반환")
  @Test
  void getRacingFinalWinnersTest() {
    assertThat(new RacingResult(GIVEN_LAP_RESULTS).getRacingFinalWinners()).isEqualTo(Set.of(new CarName("two")));
  }

}
