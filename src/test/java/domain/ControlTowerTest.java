package domain;

import domain.strategy.MoveStrategy;
import dto.ParticipationForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlTowerTest {

  private static ParticipationForm VALID_PARTICIPATION_FORM;
  private static RacingResult GIVEN_RESULTS;
  private static final MoveStrategy ALWAYS_TRUE_STRATEGY = () -> true;

  @BeforeAll
  static void setUp() {
    String ted = "ted";
    String pobi = "pobi";
    String crong = "crong";
    String honux = "honux";
    String[] attendees = new String[]{ted, pobi, crong, honux};
    int lapCount = 2;
    VALID_PARTICIPATION_FORM = new ParticipationForm(attendees, lapCount);

    RunResult firstTedResult = new RunResult(new CarName(ted), new Distance(1));
    RunResult firstPobiResult = new RunResult(new CarName(pobi), new Distance(1));
    RunResult firstCrongResult = new RunResult(new CarName(crong), new Distance(1));
    RunResult firstHonuxResult = new RunResult(new CarName(honux), new Distance(1));

    RunResult secondTedResult = new RunResult(new CarName(ted), new Distance(2));
    RunResult secondPobiResult = new RunResult(new CarName(pobi), new Distance(2));
    RunResult secondCrongResult = new RunResult(new CarName(crong), new Distance(2));
    RunResult secondHonuxResult = new RunResult(new CarName(honux), new Distance(2));
    LapResult firstResult = new LapResult(List.of(firstTedResult, firstPobiResult, firstCrongResult, firstHonuxResult));
    LapResult secondResult = new LapResult(List.of(secondTedResult, secondPobiResult, secondCrongResult, secondHonuxResult));
    GIVEN_RESULTS = new RacingResult(List.of(firstResult, secondResult));
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertThat(new ControlTower(VALID_PARTICIPATION_FORM, ALWAYS_TRUE_STRATEGY))
        .isEqualTo(new ControlTower(VALID_PARTICIPATION_FORM, ALWAYS_TRUE_STRATEGY));
  }

  @DisplayName("raceStart 메서드 테스트 입력 받은 lapCount 횟수에 맞게 경기가 실행되어야 한다.")
  @Test
  void raceStartTest() {
    assertThat(new ControlTower(VALID_PARTICIPATION_FORM, ALWAYS_TRUE_STRATEGY).raceStart())
        .isEqualTo(GIVEN_RESULTS);
  }


}
