package domain;

import java.util.Objects;

public class Distance {

  private final int value;

  public Distance(int value) {
    if(value < 0) {
      throw new IllegalArgumentException("이동 거리가 0 미만이 될 수 없습니다.");
    }
    this.value = value;
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
