package it.unibo.pps.e2;

public class KnightImpl implements Knight {
    private final int boardSize;
    private int row;
    private int col;

    public KnightImpl(final int boardSize, final int initialRow, final int initialCol) {
        if(!isInBounds(boardSize, initialRow) || !isInBounds(boardSize, initialCol)) {
            throw new IllegalArgumentException("Initial Knight position is out of bounds.");
        }
        this.boardSize = boardSize;
        this.row = initialRow;
        this.col = initialCol;
    }

    private boolean isInBounds(int boardSize, int coordinate) {
        return coordinate < boardSize && coordinate >= 0;
    }

    @Override
    public void move(final int row, final int col) {
        int x = row - this.row;
        int y = col- this.col;
        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
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
