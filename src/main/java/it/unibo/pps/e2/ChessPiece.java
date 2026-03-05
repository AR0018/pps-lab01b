package it.unibo.pps.e2;

public interface ChessPiece {

    /**
     * Moves the piece in the specified position.
     * The movement must follow the piece's pattern in chess rules. If the move is illegal (or the position is
     * out of bounds), this method does nothing.
     * @param position the position of the chess piece
     * @throws IndexOutOfBoundsException if the coordinates provided are outside the board.
     */
    void move(Pair<Integer, Integer> position);

    /**
     * @return the current position of the piece
     */
    Pair<Integer, Integer> getPosition();
}
