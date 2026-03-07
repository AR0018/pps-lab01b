package it.unibo.pps.e2;

public class KnightBehaviour implements PieceBehaviour {
    private static final int KNIGHT_MOVEMENT_DISTANCE = 3;

    @Override
    public boolean canMove(
            final int boardSize,
            final Pair<Integer, Integer> initialPosition,
            final Pair<Integer, Integer> destinationPosition) {
        int xMovement = destinationPosition.getX() - initialPosition.getX();
        int yMovement = destinationPosition.getY() - initialPosition.getY();
        return xMovement != 0 && yMovement != 0 && Math.abs(xMovement) + Math.abs(yMovement) == KNIGHT_MOVEMENT_DISTANCE;
    }
}
