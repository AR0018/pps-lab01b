package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    private static final int BOARD_SIZE = 5;
    private static final int INITIAL_ROW = 2;
    private static final int INITIAL_COL = 2;

    private Knight knight;

    @BeforeEach
    void init() {
        this.knight = new KnightImpl(BOARD_SIZE, INITIAL_ROW, INITIAL_COL);
    }

    @Test
    public void testInitialPositionIsInBounds() {
        int illegalCoordinate = -1;
        assertThrows(IllegalArgumentException.class, () -> new KnightImpl(
                BOARD_SIZE, illegalCoordinate, illegalCoordinate));
    }

    @Test
    public void testInitialSizeGreaterThanZero() {
        int illegalSize = -1;
        assertThrows(IllegalArgumentException.class, () -> new KnightImpl(
                illegalSize, 0, 0));
    }

    @Test
    public void testInitialRow() {
        assertEquals(INITIAL_ROW, this.knight.getRow());
    }

    @Test
    public void testInitialCol() {
        assertEquals(INITIAL_COL, this.knight.getCol());
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
        this.knight.move(xDestination, yDestination);
        assertEquals(xDestination, this.knight.getRow());
        assertEquals(yDestination, this.knight.getCol());
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
        this.knight.move(xDestination, yDestination);
        assertEquals(INITIAL_ROW, this.knight.getRow());
        assertEquals(INITIAL_COL, this.knight.getCol());
    }
}
