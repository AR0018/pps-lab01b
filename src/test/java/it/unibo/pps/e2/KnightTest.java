package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

    //TODO: test that the board size is > 0
}
