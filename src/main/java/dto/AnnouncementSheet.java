package dto;

import domain.*;

import java.util.*;

public class AnnouncementSheet {

  private static final String DISTANCE_INDICATOR = "-";

  private final List<Map<String, String>> fullResult;
  private final List<String> finalWinners;


  public AnnouncementSheet(RacingResult result) {
    this.fullResult = createFullResult(result);
    this.finalWinners = createFinalWinners(result);

  }

  private List<Map<String, String>> createFullResult(RacingResult result) {
    List<LapResult> lapResults = result.getLapResults();
    List<Map<String, String>> suitableForms = new ArrayList<>();
    for (LapResult resultPerLap : lapResults) {
      suitableForms.add(transformSuitableAnnouncementFormLapResult(resultPerLap));
    }
    return suitableForms;
  }

  private Map<String, String> transformSuitableAnnouncementFormLapResult(LapResult lapResult) {
    List<RunResult> records = lapResult.getRecords();
    Map<String, String> suitableForm = new HashMap<>();
    for (RunResult record : records) {
      CarName attendeeName = record.getCarName();
      Distance attendeeDistance = record.getDistance();
      suitableForm.put(attendeeName.getName(), formatDistance(attendeeDistance));
    }
    return suitableForm;
  }

  private String formatDistance(Distance distance) {
    return DISTANCE_INDICATOR.repeat(distance.getValue());
  }

  private List<String> createFinalWinners(RacingResult result) {
    List<String> winnerNames = new ArrayList<>();
    Set<CarName> racingFinalWinners = result.getRacingFinalWinners();
    for (CarName racingFinalWinner : racingFinalWinners) {
      winnerNames.add(racingFinalWinner.getName());
    }
    return winnerNames;
  }

  public List<Map<String, String>> getFullResult() {
    return fullResult;
  }

  public List<String> getFinalWinners() {
    return finalWinners;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AnnouncementSheet that = (AnnouncementSheet) o;
    return fullResult.equals(that.fullResult) && finalWinners.equals(that.finalWinners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullResult, finalWinners);
  }
}
