package dto;

import domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnnouncementSheetTest {

  private static final String TED = "ted";
  private static final String POBI = "pobi";
  private static final String CRONG = "crong";
  private static final String HONUX = "honux";
  private static final String ONCE_MOVE_INDICATOR = "-";
  private static RacingResult GIVEN_RESULTS;

  @BeforeAll
  static void setUp() {
    RunResult firstTedResult = new RunResult(new CarName(TED), new Distance(1));
    RunResult firstPobiResult = new RunResult(new CarName(POBI), new Distance(1));
    RunResult firstCrongResult = new RunResult(new CarName(CRONG), new Distance(1));
    RunResult firstHonuxResult = new RunResult(new CarName(HONUX), new Distance(1));

    LapResult firstResult = new LapResult(List.of(firstTedResult, firstPobiResult, firstCrongResult, firstHonuxResult));
    GIVEN_RESULTS = new RacingResult(List.of(firstResult));
  }

  @DisplayName("객체 생성 테스트")
  @Test
  void constructionTest() {
    assertThat(new AnnouncementSheet(GIVEN_RESULTS)).isEqualTo(new AnnouncementSheet(GIVEN_RESULTS));
  }

  @DisplayName("Lap 결과 확인")
  @Test
  void getFullResultTest() {
    Map<String, String> expectLapResult = new HashMap<>();
    expectLapResult.put(TED, ONCE_MOVE_INDICATOR);
    expectLapResult.put(POBI, ONCE_MOVE_INDICATOR);
    expectLapResult.put(CRONG, ONCE_MOVE_INDICATOR);
    expectLapResult.put(HONUX, ONCE_MOVE_INDICATOR);
    List<Map<String, String>> expect = List.of(expectLapResult);
    assertThat(new AnnouncementSheet(GIVEN_RESULTS).getFullResult()).isEqualTo(expect);
  }

  @DisplayName("우승자 명단 확인")
  @Test
  void getFinalWinnersTest() {
    List<String> expect = List.of(TED, POBI, CRONG, HONUX);
    assertThat(new AnnouncementSheet(GIVEN_RESULTS).getFinalWinners()).isEqualTo(expect);
  }

}
