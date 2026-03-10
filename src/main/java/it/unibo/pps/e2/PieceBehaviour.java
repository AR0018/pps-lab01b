package it.unibo.pps.e2;

/**
 * The behaviour of a chess piece, used to determine what moves are allowed for the given piece.
 */
public interface PieceBehaviour {
    /**
     * Checks whether a move is legal or not, based on the behaviour of the given piece.
     * @param initialPosition the initial position of the piece in the board
     * @param destinationPosition the destination position of the piece
     * @return true if the move is legal, false otherwise
     */
    boolean canMove(Pair<Integer, Integer> initialPosition, Pair<Integer, Integer> destinationPosition);
}
