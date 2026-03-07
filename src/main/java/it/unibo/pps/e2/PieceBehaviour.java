package it.unibo.pps.e2;

public interface PieceBehaviour {
    /**
     *
     * @param boardSize
     * @param initialPosition
     * @param destinationPosition
     * @return
     */
    boolean canMove(int boardSize, Pair<Integer, Integer> initialPosition, Pair<Integer, Integer> destinationPosition);
}
