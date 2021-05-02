package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    FIRST_GIVEN = List.of(one, zero, two);
    SECOND_GIVEN = List.of(four, three, five);
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertAll(() -> assertThat(new LapResult(FIRST_GIVEN)).isEqualTo(new LapResult(FIRST_GIVEN)),
              () -> assertThat(new LapResult(SECOND_GIVEN)).isEqualTo(new LapResult(SECOND_GIVEN)));
  }

}
