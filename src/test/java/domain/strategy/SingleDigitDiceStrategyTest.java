package domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class SingleDigitDiceStrategyTest {

  @DisplayName("10만번 role의 결과가 모두 0이상 9이하의 값이어야 한다.")
  @Test
  void attemptMove() {
    int tryStart = 0;
    int tryEnd = 100000;
    int minDiceValue = 0;
    int maxDiceValue = 9;
    SingleDigitDiceStrategy singleDigitDiceStrategy = new SingleDigitDiceStrategy();

    Executable[] executables = new Executable[tryEnd];
    for(int index = tryStart; index < tryEnd; index++) {
      executables[index] = () -> assertThat(singleDigitDiceStrategy.roll()).isBetween(minDiceValue, maxDiceValue);
    }

    assertAll(executables);
  }
}
