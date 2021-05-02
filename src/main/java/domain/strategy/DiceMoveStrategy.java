package domain.strategy;

public class DiceMoveStrategy implements MoveStrategy {

  private static final int DEFAULT_THRESHOLD = 4;

  private final DiceStrategy diceStrategy;
  private final int threshold;

  public DiceMoveStrategy(DiceStrategy diceStrategy, int threshold) {
    this.diceStrategy = diceStrategy;
    this.threshold = threshold;
  }

  public static DiceMoveStrategy getDefaultDice() {
    return new DiceMoveStrategy(new SingleDigitDiceStrategy(), DEFAULT_THRESHOLD);
  }

  @Override
  public boolean isMovable() {
    return diceStrategy.roll() >= threshold;
  }
}
