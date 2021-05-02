package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RunResultTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(strings = {"ted", "pobi", "crong", "honux"})
  @ParameterizedTest
  void constructionTest(String givenName) {
    assertThat(new RunResult(new CarName(givenName), Distance.initialize())).isEqualTo(new RunResult(new CarName(givenName), Distance.initialize()));
  }

  @DisplayName("이름이 같아도 거리가 다르면 다른 객체 취급")
  @Test
  void shouldEqualNameAndDistanceTest() {
    CarName givenName = new CarName("ted");
    Distance zero = Distance.initialize();
    Distance one = new Distance(1);
    assertThat(new RunResult(givenName, zero)).isNotEqualTo(new RunResult(givenName, one));
  }

  @DisplayName("RunResult의 compareTo 결과는 내림차순 정렬")
  @Test
  void compareToTest() {
    RunResult zero = new RunResult(new CarName("zero"), new Distance(0));
    RunResult one = new RunResult(new CarName("one"), new Distance(1));
    RunResult two = new RunResult(new CarName("two"), new Distance(2));
    List<RunResult> runResults = new ArrayList<>();
    runResults.add(one);
    runResults.add(zero);
    runResults.add(two);

    Collections.sort(runResults);
    assertThat(runResults).containsExactly(two, one, zero);
  }

}
