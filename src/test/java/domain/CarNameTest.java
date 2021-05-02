package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(strings = {"ted", "pobi", "crong", "honux"})
  @ParameterizedTest
  void constructionTest(String given) {
    assertThat(new CarName(given)).isEqualTo(new CarName(given));
  }

  @DisplayName("빈 문자열이 입력되면 객체 생성 실패")
  @NullAndEmptySource
  @ParameterizedTest
  void constructionFailByNullAndEmptySourceTest(String given) {
    assertThatThrownBy(() -> new CarName(given)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("차량 이름이 빈 문자열일 수 없습니다.");
  }

  @DisplayName("문자열 길이가 5를 넘으면 객체 생성 실패")
  @ValueSource(strings = {"abcdef", "가나다라마바", "123456"})
  @ParameterizedTest
  void constructionFailByLengthGreaterThanFiveTest(String given) {
    assertThatThrownBy(() -> new CarName(given)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("차량 이름은 최대 5자 입니다.");
  }

}
