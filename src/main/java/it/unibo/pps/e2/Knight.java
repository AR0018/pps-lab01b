package it.unibo.pps.e2;

public interface Knight {

    /**
     * Moves the knight in the specified position.
     * The movement must follow the knight's pattern in chess rules. If the move is illegal (or the position is
     * out of bounds), this method does nothing.
     * @param row the destination row
     * @param col the destination column
     * @throws IndexOutOfBoundsException if the coordinates provided are outside the board.
     */
    void move(int row, int col);

    /**
     * @return the current row of the knight
     */
    int getRow();

    /**
     * @return the current column of the knight
     */
    int getCol();
}
