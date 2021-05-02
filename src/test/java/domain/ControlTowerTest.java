package domain;

import domain.strategy.MoveStrategy;
import dto.ParticipationForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ControlTowerTest {

  private static ParticipationForm VALID_PARTICIPATION_FORM;
  private static final MoveStrategy ALWAYS_TRUE_STRATEGY = () -> true;

  @BeforeAll
  static void setUp() {
    String[] attendees = new String[]{"ted", "pobi", "crong", "honux"};
    int lapCount = 2;
    VALID_PARTICIPATION_FORM = new ParticipationForm(attendees, lapCount);
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertThat(new ControlTower(VALID_PARTICIPATION_FORM, ALWAYS_TRUE_STRATEGY)).isEqualTo(new ControlTower(VALID_PARTICIPATION_FORM, ALWAYS_TRUE_STRATEGY));
  }


}
