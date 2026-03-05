package it.unibo.pps.e2;

public class KnightImpl implements ChessPiece {
    private static final int KNIGHT_MOVEMENT_DISTANCE = 3;
    private final int boardSize;
    private Pair<Integer, Integer> position;

    public KnightImpl(final int boardSize, final Pair<Integer, Integer> initialPosition) {
        if(isOutOfBounds(boardSize, initialPosition)) {
            throw new IllegalArgumentException("Initial Knight position is out of bounds.");
        }
        this.boardSize = boardSize;
        this.position = initialPosition;
    }

    private boolean isOutOfBounds(final int boardSize, final Pair<Integer, Integer> position) {
        return position.getX() >= boardSize || position.getX() < 0
                || position.getY() >= boardSize || position.getY() < 0;
    }

    @Override
    public void move(final Pair<Integer, Integer> position) {
        if(isOutOfBounds(this.boardSize, position)) {
            throw new IndexOutOfBoundsException("Desired move is out of bounds.");
        }
        int xMovement = position.getX() - this.position.getX();
        int yMovement = position.getY() - this.position.getY();
        if (xMovement != 0 && yMovement != 0 && Math.abs(xMovement) + Math.abs(yMovement) == KNIGHT_MOVEMENT_DISTANCE) {
            this.position = position;
        }
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
