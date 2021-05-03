package ui;

import dto.AnnouncementSheet;

import java.util.List;
import java.util.Map;

public class Announcer {
  private static final String RACE_RESULT = "실행 결과";
  private static final String WINNER_NAME_DELIMITER = ", ";
  private static final String LAP_RESULT_FORMAT = "%s : %s";
  private static final String FINAL_WINNERS_FORMAT = "%s가 최종 우승했습니다.";
  private static final int FIRST_INDEX = 0;

  private Announcer() {
  }

  public static void announcement(AnnouncementSheet announcementSheet) {
    System.out.println(System.lineSeparator());
    System.out.println(RACE_RESULT);
    announceResultPerLaps(announcementSheet.getFullResult());
    announceFinalWinners(announcementSheet.getFinalWinners());

  }

  private static void announceFinalWinners(List<String> finalWinners) {
    System.out.println(String.format(FINAL_WINNERS_FORMAT, buildWinnersString(finalWinners)));
  }

  private static String buildWinnersString(List<String> finalWinners) {
    StringBuilder winnersBuilder = new StringBuilder();
    for (int index = FIRST_INDEX; index < finalWinners.size(); index++) {
      String finalWinner = finalWinners.get(index);
      appendDelimiterIfNotFirstElement(winnersBuilder, index);
      winnersBuilder.append(finalWinner);
    }
    return winnersBuilder.toString();
  }

  private static void appendDelimiterIfNotFirstElement(StringBuilder winnersBuilder, int index) {
    if (index != FIRST_INDEX) {
      winnersBuilder.append(WINNER_NAME_DELIMITER);
    }
  }

  private static void announceResultPerLaps(List<Map<String, String>> fullResult) {
    for (Map<String, String> lapResult : fullResult) {
      announceLapResult(lapResult);
      System.out.println(System.lineSeparator());
    }

  }

  private static void announceLapResult(Map<String, String> lapResult) {
    for (Map.Entry<String, String> resultEntry : lapResult.entrySet()) {
      System.out.println(String.format(LAP_RESULT_FORMAT, resultEntry.getKey(), resultEntry.getValue()));
    }
  }
}
