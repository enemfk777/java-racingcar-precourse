package domain;

import domain.strategy.MoveStrategy;

import java.util.*;

public class RacingCars {

  private static final String DUPLICATED_ATTENDEE_NAME = "같은 이름의 참여자가 있습니다. 참여자의 이름은 모두 달라야 합니다.";

  private final Set<Car> cars;

  private RacingCars(Set<Car> cars) {
    this.cars = cars;
  }

  public static RacingCars fromAttendeeNamesWithMoveStrategy(List<String> attendeeNames, MoveStrategy moveStrategy) {
    Set<Car> preparedCars = new LinkedHashSet<>();
    for (String attendeeName : attendeeNames) {
      Car attendee = Car.initializeCar(attendeeName, moveStrategy);
      addNonDuplicatedCar(preparedCars, attendee);
    }
    return new RacingCars(preparedCars);
  }
  private static void addNonDuplicatedCar(Set<Car> preparedCars, Car attendee) {
    if(!preparedCars.add(attendee)) {
      throw new IllegalArgumentException(DUPLICATED_ATTENDEE_NAME);
    }
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
