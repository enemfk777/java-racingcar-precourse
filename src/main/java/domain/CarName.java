package domain;

import java.util.Objects;

public class CarName {

  private static final int NAME_MAX_LENGTH = 5;
  private static final String NAME_MUST_NOT_NULL_AND_EMPTY = "차량 이름이 빈 문자열일 수 없습니다.";
  private static final String NAME_LENGTH_MUST_LESS_EQUAL_THAN_MAX_LENGTH_FORMAT = "차량 이름은 최대 %d자 입니다.";

  private final String name;

  public CarName(String name) {
    throwExceptionIfNull(name);
    String trimName = name.trim();
    throwExceptionIfEmpty(trimName);
    throwExceptionIfLengthGreaterThanMaxLength(trimName);
    this.name = trimName;
  }

  public String getName() {
    return name;
  }

  private void throwExceptionIfNull(String name) {
    if (name == null) {
      throw new IllegalArgumentException(NAME_MUST_NOT_NULL_AND_EMPTY);
    }
  }

  private void throwExceptionIfEmpty(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException(NAME_MUST_NOT_NULL_AND_EMPTY);
    }
  }

  private void throwExceptionIfLengthGreaterThanMaxLength(String name) {
    if (name.length() > NAME_MAX_LENGTH) {
      throw new IllegalArgumentException(String.format(NAME_LENGTH_MUST_LESS_EQUAL_THAN_MAX_LENGTH_FORMAT, NAME_MAX_LENGTH));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarName carName = (CarName) o;
    return name.equals(carName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
