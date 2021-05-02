package domain.strategy;

public class DiceMoveStrategy implements MoveStrategy {

  private final DiceStrategy diceStrategy;
  private final int threshold;

  public DiceMoveStrategy(DiceStrategy diceStrategy, int threshold) {
    this.diceStrategy = diceStrategy;
    this.threshold = threshold;
  }

  @Override
  public boolean isMovable() {
    return diceStrategy.roll() >= threshold;
  }
}
