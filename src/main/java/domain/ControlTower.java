package domain;

import domain.strategy.MoveStrategy;
import dto.ParticipationForm;

import java.util.Objects;
import java.util.Set;

public class ControlTower {

  private final RacingCars attendedCars;
  private final LapCount lapCount;

  public ControlTower(ParticipationForm participationForm) {
    this.attendedCars = generateRacingCarsWithDefaultStrategy(participationForm.getAttendeeNames());
    this.lapCount = new LapCount(participationForm.getLapCount());
  }

  //For Test Code
  ControlTower(ParticipationForm participationForm, MoveStrategy moveStrategy) {
    this.attendedCars = RacingCars.fromAttendeeNamesWithMoveStrategy(participationForm.getAttendeeNames(), moveStrategy);
    this.lapCount = new LapCount(participationForm.getLapCount());
  }

  private RacingCars generateRacingCarsWithDefaultStrategy(Set<String> attendeeNames) {
    return RacingCars.fromAttendeeNamesWithMoveStrategy(attendeeNames, MoveStrategy.getDefaultMoveStrategy());
  }

  public RacingResult raceStart() {
    return lapCount.raceEachLaps(attendedCars);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ControlTower that = (ControlTower) o;
    return attendedCars.equals(that.attendedCars) && lapCount.equals(that.lapCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attendedCars, lapCount);
  }
}
