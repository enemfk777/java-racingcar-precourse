package domain.strategy;

public interface MoveStrategy {

  static MoveStrategy getDefaultMoveStrategy() {
    return DiceMoveStrategy.getDefaultDice();
  }

  boolean isMovable();
}
