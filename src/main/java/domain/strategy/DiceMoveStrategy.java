package domain.strategy;

public class DiceMoveStrategy implements MoveStrategy {
  public DiceMoveStrategy(DiceStrategy diceStrategy, int threshold) {

  }

  @Override
  public boolean isMovable() {
    return false;
  }
}
