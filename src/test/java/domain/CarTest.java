package domain;

import domain.strategy.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(strings = {"ted", "pobi", "crong", "honux"})
  @ParameterizedTest
  void constructionTest(String givenName) {
    MoveStrategy trueStrategy =  () -> true;
    assertThat(Car.initializeCar(givenName, trueStrategy)).isEqualTo(Car.initializeCar(givenName, trueStrategy));
  }

  @DisplayName("이름이 같아도 이동 전략이 다른 객체는 다른 객체로 취급한다.")
  @Test
  void shouldEqualNameAndMoveStrategy() {
    String givenName = "ted";
    MoveStrategy trueStrategy = () -> true;
    MoveStrategy falseStrategy = () -> false;
    assertThat(Car.initializeCar(givenName, trueStrategy)).isNotEqualTo(Car.initializeCar(givenName, falseStrategy));
  }

}
