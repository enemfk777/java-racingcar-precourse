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

  public static RacingCars fromParticipationNamesWithMoveStrategy(List<String> participationNames, MoveStrategy moveStrategy) {
    List<Car> preparedCars = new ArrayList<>();
    for (String participationName : participationNames) {
      Car participatedCar = Car.initializeCar(participationName, moveStrategy);
      preparedCars.add(participatedCar);
    }
    return new RacingCars(preparedCars);
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
