package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChessPieceTest {
    protected static final int ILLEGAL_COORDINATE = -1;
    protected static final int BOARD_SIZE = 5;
    protected static final int INITIAL_ROW = 2;
    protected static final int INITIAL_COL = 2;

    private ChessPiece chessPiece;
    private PieceBehaviour behaviour;

    @BeforeEach
    void init() {
        this.behaviour = (BOARD_SIZE, initial, destination) -> true;
        this.chessPiece = new ChessPieceImpl(
                BOARD_SIZE,
                new Pair<>(INITIAL_ROW, INITIAL_COL),
                this.behaviour);
    }

    protected ChessPiece getChessPiece() {
        return this.chessPiece;
    }

    protected void setChessPiece(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    @Test
    public void testInitialPositionIsInBounds() {
        assertThrows(IllegalArgumentException.class, () -> new ChessPieceImpl(
                BOARD_SIZE, new Pair<>(ILLEGAL_COORDINATE, ILLEGAL_COORDINATE), this.behaviour));
    }

    @Test
    public void testInitialSizeGreaterThanZero() {
        int illegalSize = -1;
        assertThrows(IllegalArgumentException.class, () -> new ChessPieceImpl(
                illegalSize, new Pair<>(0, 0), this.behaviour));
    }

    @Test
    public void testInitialPosition() {
        assertEquals(new Pair<>(INITIAL_ROW, INITIAL_COL), this.chessPiece.getPosition());
    }

    @Test
    public void testMovementOutOfBounds() {
        int initialMoveRow = 0;
        int initialMoveCol = 1;
        this.chessPiece.move(new Pair<>(initialMoveRow, initialMoveCol));
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.chessPiece.move(new Pair<>(ILLEGAL_COORDINATE, ILLEGAL_COORDINATE)));
    }
}
