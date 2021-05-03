package domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RacingResult {

  private static final int DIFFERENCE_BETWEEN_SIZE_AND_LAST_INDEX = 1;

  private final List<LapResult> lapResults;

  public RacingResult(List<LapResult> lapResults) {
    this.lapResults = lapResults;
  }

  public Set<CarName> getRacingFinalWinners() {
    int lastLapIndex = lapResults.size() - DIFFERENCE_BETWEEN_SIZE_AND_LAST_INDEX;
    LapResult lastLapResult = lapResults.get(lastLapIndex);
    return lastLapResult.getLapWinners();
  }

  public List<LapResult> getLapResults() {
    return lapResults;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RacingResult that = (RacingResult) o;
    return lapResults.equals(that.lapResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lapResults);
  }
}
