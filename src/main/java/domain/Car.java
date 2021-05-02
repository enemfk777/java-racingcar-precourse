package domain;

import domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

  private final CarName carName;
  private final MoveStrategy moveStrategy;
  private Distance distance;

  Car(CarName carName, MoveStrategy moveStrategy, Distance distance) {
    this.carName = carName;
    this.moveStrategy = moveStrategy;
    this.distance = distance;
  }

  public static Car initializeCar(String carName, MoveStrategy moveStrategy) {
    return new Car(new CarName(carName), moveStrategy, Distance.initialize());
  }

  public RunResult run() {
    if(moveStrategy.isMovable()) {
      updateDistance();
    }
    return new RunResult(carName, distance);
  }

  private void updateDistance() {
    distance = distance.increase();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return carName.equals(car.carName) && moveStrategy.equals(car.moveStrategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName, moveStrategy);
  }
}
