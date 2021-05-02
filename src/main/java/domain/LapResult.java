package domain;

import java.util.*;

public class LapResult {

  private static final int FIRST_INDEX = 0;

  private final List<RunResult> records;
  private final Distance lapWinnersDistance;

  public LapResult(List<RunResult> records) {
    this.records = records;
    this.lapWinnersDistance = getFirstCarsDistance();
  }

  public Set<CarName> getLapWinners() {
    Set<CarName> lapWinnerNames = new LinkedHashSet<>();
    for (RunResult record : records) {
      collectWinnerNames(lapWinnerNames, record);
    }
    return lapWinnerNames;
  }

  private void collectWinnerNames(Set<CarName> lapWinnerNames, RunResult record) {
    if(lapWinnersDistance.equals(record.getDistance())) {
      lapWinnerNames.add(record.getCarName());
    }
  }

  private Distance getFirstCarsDistance() {
    List<RunResult> toSort = new ArrayList<>(records);
    Collections.sort(toSort);
    RunResult firstResult = toSort.get(FIRST_INDEX);
    return firstResult.getDistance();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LapResult lapResult = (LapResult) o;
    return records.equals(lapResult.records);
  }

  @Override
  public int hashCode() {
    return Objects.hash(records);
  }
}
