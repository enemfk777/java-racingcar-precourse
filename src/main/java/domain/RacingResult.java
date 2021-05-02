package domain;

import java.util.List;
import java.util.Objects;

public class RacingResult {

  private final List<LapResult> lapResults;

  public RacingResult(List<LapResult> lapResults) {
    this.lapResults = lapResults;
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
