package domain;

import java.util.Objects;

public class LapCount {

  private static final String LAP_COUNT_MUST_NOT_LESS_THAN_MIN_VALUE_FORMAT = "시도할 회수(Lap 수)가 %d 미만이 될 수 없습니다.";

  private static final int MIN_VALUE = 1;

  private final int count;

  public LapCount(int count) {
    if(count < MIN_VALUE) {
      throw new IllegalArgumentException(String.format(LAP_COUNT_MUST_NOT_LESS_THAN_MIN_VALUE_FORMAT, MIN_VALUE));
    }
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LapCount lapCount = (LapCount) o;
    return count == lapCount.count;
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }
}
