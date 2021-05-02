package domain;

import java.util.Objects;

public class Distance {

  private static final int MIN_VALUE = 0;
  private static final String DISTANCE_MUST_NOT_LESS_THAN_MIN_VALUE_FORMAT = "이동 거리가 %d 미만이 될 수 없습니다.";

  private final int value;

  public Distance(int value) {
    if(value < MIN_VALUE) {
      throw new IllegalArgumentException(String.format(DISTANCE_MUST_NOT_LESS_THAN_MIN_VALUE_FORMAT, MIN_VALUE));
    }
    this.value = value;
  }

  public static Distance initialize() {
    return new Distance(MIN_VALUE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Distance distance1 = (Distance) o;
    return value == distance1.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
