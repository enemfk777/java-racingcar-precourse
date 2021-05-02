package domain;

import domain.strategy.MoveStrategy;

import java.util.*;

public class RacingCars {

  private final Set<Car> cars;

  private RacingCars(Set<Car> cars) {
    this.cars = cars;
  }

  public static RacingCars fromAttendeeNamesWithMoveStrategy(Set<String> attendeeNames, MoveStrategy moveStrategy) {
    Set<Car> preparedCars = new LinkedHashSet<>();
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
