package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final ChessPiece pawn;
	private final ChessPiece knight;
	private final Random random = new Random();
	private final int size;
	private final PieceBehaviour noMovementBehaviour = (initial, destination) -> false;

    public LogicsImpl(final int size){
    	this.size = size;
        this.pawn = new ChessPieceImpl(size, randomEmptyPosition(), noMovementBehaviour);
        this.knight = new ChessPieceImpl(size, randomEmptyPosition(), new KnightBehaviour());
    }

    public LogicsImpl(final int size, final Pair<Integer, Integer> pawnPosition, final Pair<Integer, Integer> knightPosition) {
        this.size = size;
        this.pawn = new ChessPieceImpl(size, pawnPosition, noMovementBehaviour);
        this.knight = new ChessPieceImpl(size, knightPosition, new KnightBehaviour());
    }
    
	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(final int row, final int col) {
		this.knight.move(new Pair<>(row, col));
		return this.pawn.getPosition().equals(this.knight.getPosition());
	}

	@Override
	public boolean hasKnight(final int row, final int col) {
		return this.knight.getPosition().equals(new Pair<>(row, col));
	}

	@Override
	public boolean hasPawn(final int row, final int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
