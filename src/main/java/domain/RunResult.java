package domain;

import java.util.Objects;

public class RunResult {

  private final CarName carName;
  private final Distance distance;

  public RunResult(CarName carName, Distance distance) {
    this.carName = carName;
    this.distance = distance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RunResult runResult = (RunResult) o;
    return carName.equals(runResult.carName) && distance.equals(runResult.distance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName, distance);
  }
}
