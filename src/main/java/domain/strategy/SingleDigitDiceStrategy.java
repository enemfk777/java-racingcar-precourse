package domain.strategy;

import java.util.Random;

public class SingleDigitDiceStrategy implements DiceStrategy {

  private static final int DICE_LIMIT = 10;

  private Random dice = new Random();
  @Override
  public int roll() {
    return dice.nextInt(DICE_LIMIT);
  }
}
