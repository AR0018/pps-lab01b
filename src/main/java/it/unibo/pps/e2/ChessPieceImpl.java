package it.unibo.pps.e2;

public class ChessPieceImpl implements ChessPiece {
    private final int boardSize;
    private Pair<Integer, Integer> position;
    private final PieceBehaviour behaviour;

    public ChessPieceImpl(final int boardSize, final Pair<Integer, Integer> initialPosition, final PieceBehaviour behaviour) {
        if(isOutOfBounds(boardSize, initialPosition)) {
            throw new IllegalArgumentException("Initial Knight position is out of bounds.");
        }
        this.boardSize = boardSize;
        this.position = initialPosition;
        this.behaviour = behaviour;
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
        this.position = this.behaviour.canMove(this.boardSize, this.position, position) ?
                position : this.position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
