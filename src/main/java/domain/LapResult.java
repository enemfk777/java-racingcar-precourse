package domain;

import java.util.List;
import java.util.Objects;

public class LapResult {

  private final List<RunResult> runResults;

  public LapResult(List<RunResult> runResults) {
    this.runResults = runResults;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LapResult lapResult = (LapResult) o;
    return runResults.equals(lapResult.runResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runResults);
  }
}
