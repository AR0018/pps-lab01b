package it.unibo.pps.e2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicsTest {

    public static final int SIZE = 5;
    public static final int KNIGHT_X = 2;
    public static final int KNIGHT_Y = 2;
    public static final int PAWN_X = 0;
    public static final int PAWN_Y = 1;

    private Logics logic;

    @BeforeEach
    void init() {
        this.logic = new LogicsImpl(SIZE, new Pair<>(PAWN_X, PAWN_Y), new Pair<>(KNIGHT_X, KNIGHT_Y));
    }

    @Test
    public void testKnightInitialPos() {
        assertTrue(this.logic.hasKnight(KNIGHT_X, KNIGHT_Y));
    }

    @Test
    public void testPawnInitialPos() {
        assertTrue(this.logic.hasPawn(PAWN_X, PAWN_Y));
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
    public void testHitWithLegalMove(final int xDestination, final int yDestination) {
        this.logic.hit(xDestination, yDestination);
        assertTrue(this.logic.hasKnight(xDestination, yDestination));
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
    public void testHitWithIllegalMove(final int xDestination, final int yDestination) {
        this.logic.hit(xDestination, yDestination);
        assertTrue(this.logic.hasKnight(KNIGHT_X, KNIGHT_Y));
    }

    @Test
    public void testHitsPawn() {
        assertTrue(this.logic.hit(PAWN_X, PAWN_Y));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 0",
            "4, 1",
            "4, 3",
            "3, 4",
            "1, 4",
            "0, 3"
    })
    public void testDoesNotHitPawn(final int xDestination, final int yDestination) {
        assertFalse(this.logic.hit(xDestination, yDestination));
    }
}
