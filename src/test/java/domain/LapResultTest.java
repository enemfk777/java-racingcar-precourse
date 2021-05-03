package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LapResultTest {

  private static List<RunResult> FIRST_GIVEN;
  private static List<RunResult> SECOND_GIVEN;

  @BeforeAll
  static void setUp() {
    RunResult zero = new RunResult(new CarName("zero"), new Distance(0));
    RunResult one = new RunResult(new CarName("one"), new Distance(1));
    RunResult two = new RunResult(new CarName("two"), new Distance(2));
    RunResult three = new RunResult(new CarName("three"), new Distance(3));
    RunResult four = new RunResult(new CarName("four"), new Distance(4));
    RunResult five = new RunResult(new CarName("five"), new Distance(5));
    RunResult five2 = new RunResult(new CarName("five2"), new Distance(5));
    FIRST_GIVEN = List.of(one, zero, two);
    SECOND_GIVEN = List.of(four, three, five, five2);
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertAll(() -> assertThat(new LapResult(FIRST_GIVEN)).isEqualTo(new LapResult(FIRST_GIVEN)),
        () -> assertThat(new LapResult(SECOND_GIVEN)).isEqualTo(new LapResult(SECOND_GIVEN)));
  }

  @DisplayName("현재 Lap의 1등의 이름을 반환한다. 중복 일경우 중복되는 인원 모두 반환한다.")
  @Test
  void getLapWinnersTest() {
    assertThat(new LapResult(FIRST_GIVEN).getLapWinners()).isEqualTo(Set.of(new CarName("two")));
    assertThat(new LapResult(SECOND_GIVEN).getLapWinners()).isEqualTo(Set.of(new CarName("five"), new CarName("five2")));
  }

}
