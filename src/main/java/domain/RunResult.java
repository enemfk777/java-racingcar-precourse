package domain;

import java.util.Objects;

public class RunResult implements Comparable<RunResult> {

  private final CarName carName;
  private final Distance distance;

  public RunResult(CarName carName, Distance distance) {
    this.carName = carName;
    this.distance = distance;
  }

  public CarName getCarName() {
    return carName;
  }

  public Distance getDistance() {
    return distance;
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

  @Override
  public int compareTo(RunResult o) {
    return o.distance.compareTo(this.distance);
  }
}
