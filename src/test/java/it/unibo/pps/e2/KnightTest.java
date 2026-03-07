package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest extends ChessPieceTest {

    @Override
    @BeforeEach
    void init() {
        setChessPiece(new KnightImpl(BOARD_SIZE, new Pair<>(INITIAL_ROW, INITIAL_COL)));
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
        getChessPiece().move(new Pair<>(xDestination, yDestination));
        assertEquals(new Pair<>(xDestination, yDestination), getChessPiece().getPosition());
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
        getChessPiece().move(new Pair<>(xDestination, yDestination));
        assertEquals(new Pair<>(INITIAL_ROW, INITIAL_COL), getChessPiece().getPosition());
    }
}
