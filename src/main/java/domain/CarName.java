package domain;

import java.util.Objects;

public class CarName {

  private final String name;

  public CarName(String name) {
    if(name == null || name.isEmpty()) {
      throw new IllegalArgumentException("차량 이름이 빈 문자열일 수 없습니다.");
    }
    if(name.length() > 5) {
      throw new IllegalArgumentException("차량 이름은 최대 5자 입니다.");
    }
    this.name = name;
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
