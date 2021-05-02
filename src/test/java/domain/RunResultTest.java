package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

}
