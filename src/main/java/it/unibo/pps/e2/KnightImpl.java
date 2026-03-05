package it.unibo.pps.e2;

public class KnightImpl implements Knight {
    private static final int KNIGHT_MOVEMENT_DISTANCE = 3;
    private final int boardSize;
    private int row;
    private int col;

    public KnightImpl(final int boardSize, final int initialRow, final int initialCol) {
        if(isOutOfBounds(boardSize, initialRow) || isOutOfBounds(boardSize, initialCol)) {
            throw new IllegalArgumentException("Initial Knight position is out of bounds.");
        }
        this.boardSize = boardSize;
        this.row = initialRow;
        this.col = initialCol;
    }

    private boolean isOutOfBounds(int boardSize, int coordinate) {
        return coordinate >= boardSize || coordinate < 0;
    }

    @Override
    public void move(final int row, final int col) {
        if(isOutOfBounds(this.boardSize, row) || isOutOfBounds(this.boardSize, col)) {
            throw new IndexOutOfBoundsException("Desired move is out of bounds.");
        }
        int xMovement = row - this.row;
        int yMovement = col- this.col;
        if (xMovement != 0 && yMovement != 0 && Math.abs(xMovement) + Math.abs(yMovement) == KNIGHT_MOVEMENT_DISTANCE) {
            this.row = row;
            this.col = col;
        }
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getCol() {
        return this.col;
    }
}
