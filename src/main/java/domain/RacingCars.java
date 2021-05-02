package domain;

import domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {

  private final List<Car> cars;

  private RacingCars(List<Car> cars) {
    this.cars = cars;
  }

  public static RacingCars fromAttendeeNamesWithMoveStrategy(List<String> attendeeNames, MoveStrategy moveStrategy) {
    List<Car> preparedCars = new ArrayList<>();
    for (String attendeeName : attendeeNames) {
      Car attendee = Car.initializeCar(attendeeName, moveStrategy);
      preparedCars.add(attendee);
    }
    return new RacingCars(preparedCars);
  }

  public LapResult raceOneLap() {
    List<RunResult> lapResults = new ArrayList<>();
    for (Car attendee : cars) {
      RunResult attendeesResult = attendee.run();
      lapResults.add(attendeesResult);
    }
    return new LapResult(lapResults);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RacingCars that = (RacingCars) o;
    return cars.equals(that.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars);
  }
}
