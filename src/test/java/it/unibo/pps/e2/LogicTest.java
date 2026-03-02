package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {

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

    // TODO: Add your test logic here
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);

    @Test
    public void testKnightInitialPos() {
        assertTrue(this.logic.hasKnight(KNIGHT_X, KNIGHT_Y));
    }

    @Test
    public void testPawnInitialPos() {
        assertTrue(this.logic.hasPawn(PAWN_X, PAWN_Y));
    }

    @Test
    public void testHitWithLegalMove() {
        int xDestination = 1;
        int yDestination = 0;
        this.logic.hit(xDestination, yDestination);
        assertTrue(this.logic.hasKnight(xDestination, yDestination));
    }

    @Test
    public void testHitWithIllegalMove() {
        int xDestination = 4;
        int yDestination = 0;
        this.logic.hit(xDestination, yDestination);
        assertTrue(this.logic.hasKnight(KNIGHT_X, KNIGHT_Y));
    }
}
