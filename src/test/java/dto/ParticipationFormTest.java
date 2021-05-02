package dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipationFormTest {

  private static final String[] VALID_NAMES = new String[]{"ted", "pobi", "crong", "honux"};
  private static final int VALID_LAP_COUNT = 2;

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertThat(new ParticipationForm(VALID_NAMES, VALID_LAP_COUNT)).isEqualTo(new ParticipationForm(VALID_NAMES, VALID_LAP_COUNT));
  }

  @DisplayName("잘못 된 길이의 참가 대수 목록 입력시 IllegalArgumentException")
  @Test
  void constructionFailWhenWrongAttendeeCountTest() {
    String[] wrongAttendees = new String[]{};
    assertThatThrownBy(() -> new ParticipationForm(wrongAttendees, VALID_LAP_COUNT)).isInstanceOf(IllegalArgumentException.class)
                      .hasMessageContaining("참가 대수의 최소 값은 1입니다. 입력 된 값 : 0");
  }

  @DisplayName("잘못 된 길이의 시도 회수 입력시 IllegalArgumentException")
  @Test
  void constructionFailWhenWrongLapCountTest() {
    int wrongLapCount = 0;
    assertThatThrownBy(() -> new ParticipationForm(VALID_NAMES, wrongLapCount)).isInstanceOf(IllegalArgumentException.class)
                      .hasMessageContaining("시도할 회수의 최소 값은 1입니다. 입력 된 값 : 0");
  }

  @DisplayName("차량 이름으로 빈 문자열이 들어오면 IllegalArgumentException")
  @Test
  void constructionFailWhenBlankNameTest() {
    String[] wrongAttendees = new String[]{" ", "ted"};
    assertThatThrownBy(() -> new ParticipationForm(wrongAttendees, VALID_LAP_COUNT)).isInstanceOf(IllegalArgumentException.class)
                      .hasMessageContaining("차량 이름이 빈 문자열일 수 없습니다.");
  }

  @DisplayName("차량 이름으로 5글자를 초과하는 이름이 들어오면 IllegalArgumentException")
  @Test
  void constructionFailWhenNameLengthGreaterThanFiveTest() {
    String[] wrongAttendees = new String[]{"abcdef", "ted"};
    assertThatThrownBy(() -> new ParticipationForm(wrongAttendees, VALID_LAP_COUNT)).isInstanceOf(IllegalArgumentException.class)
                      .hasMessageContaining("차량 이름은 최대 5자 입니다.");
  }

  @DisplayName("차량 이름으로 중복된 이름이 들어오면 IllegalArgumentException")
  @Test
  void constructionFailWhenDuplicateNameTest() {
    String[] wrongAttendees = new String[]{"ted", "ted"};
    assertThatThrownBy(() -> new ParticipationForm(wrongAttendees, VALID_LAP_COUNT)).isInstanceOf(IllegalArgumentException.class)
                      .hasMessageContaining("같은 이름의 참여자가 있습니다. 참여자의 이름은 모두 달라야 합니다.");
  }
}
