package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    public static final int ILLEGAL_COORDINATE = -1;
    private static final int BOARD_SIZE = 5;
    private static final int INITIAL_ROW = 2;
    private static final int INITIAL_COL = 2;

    private ChessPiece knight;

    @BeforeEach
    void init() {
        this.knight = new KnightImpl(BOARD_SIZE, new Pair<>(INITIAL_ROW, INITIAL_COL));
    }

    @Test
    public void testInitialPositionIsInBounds() {
        assertThrows(IllegalArgumentException.class, () -> new KnightImpl(
                BOARD_SIZE, new Pair<>(ILLEGAL_COORDINATE, ILLEGAL_COORDINATE)));
    }

    @Test
    public void testInitialSizeGreaterThanZero() {
        int illegalSize = -1;
        assertThrows(IllegalArgumentException.class, () -> new KnightImpl(
                illegalSize, new Pair<>(0, 0)));
    }

    @Test
    public void testInitialPosition() {
        assertEquals(new Pair<>(INITIAL_ROW, INITIAL_COL), this.knight.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 0",
            "4, 1",
            "4, 3",
            "3, 4",
            "1, 4",
            "0, 3",
            "0, 1"
    })
    public void testMovementWithLegalMove(final int xDestination, final int yDestination) {
        this.knight.move(new Pair<>(xDestination, yDestination));
        assertEquals(new Pair<>(xDestination, yDestination), this.knight.getPosition());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1",
            "3, 1",
            "1, 2",
            "3, 2",
            "1, 3",
            "2, 3",
            "3, 3",
            "0, 0",
            "2, 0",
            "4, 0",
            "0, 2",
            "4, 2",
            "0, 4",
            "2, 4",
            "4, 4"
    })
    public void testMovementWithIllegalMove(final int xDestination, final int yDestination) {
        this.knight.move(new Pair<>(xDestination, yDestination));
        assertEquals(new Pair<>(INITIAL_ROW, INITIAL_COL), this.knight.getPosition());
    }

    @Test
    public void testMovementOutOfBounds() {
        int initialMoveRow = 0;
        int initialMoveCol = 1;
        this.knight.move(new Pair<>(initialMoveRow, initialMoveCol));
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.knight.move(new Pair<>(ILLEGAL_COORDINATE, ILLEGAL_COORDINATE)));
    }
}
