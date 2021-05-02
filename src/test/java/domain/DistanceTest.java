package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DistanceTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(ints = {1, 2, 3, Integer.MAX_VALUE})
  @ParameterizedTest
  void constructionTest(int given) {
    assertThat(new Distance(given)).isEqualTo(new Distance(given));
  }

  @DisplayName("초기화 메서드 리턴값은 0")
  @Test
  void initializeTest() {
    assertThat(Distance.initialize()).isEqualTo(new Distance(0));
  }

  @DisplayName("0 미만의 값이 입력되면 객체 생성 실패")
  @ValueSource(ints = {-1, -2, -3, Integer.MIN_VALUE})
  @ParameterizedTest
  void constructionFailByNullAndEmptySourceTest(int given) {
    assertThatThrownBy(() -> new Distance(given)).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이동 거리가 0 미만이 될 수 없습니다.");
  }

  @DisplayName("값 증가는 1씩")
  @CsvSource(value = {"1,2", "3,4", "100,101"}, delimiter = ',')
  @ParameterizedTest
  void increaseByOneTest(int given, int increaseResult) {
    assertThat(new Distance(given).increase()).isEqualTo(new Distance(increaseResult));
  }

  @DisplayName("Distance의 compareTo 결과는 오름차순 정렬")
  @Test
  void compareToTest() {
    Distance zero = new Distance(0);
    Distance one = new Distance(1);
    Distance two = new Distance(2);
    List<Distance> distances = new ArrayList<>();
    distances.add(one);
    distances.add(zero);
    distances.add(two);

    Collections.sort(distances);
    assertThat(distances).containsExactly(zero, one, two);
  }


}
