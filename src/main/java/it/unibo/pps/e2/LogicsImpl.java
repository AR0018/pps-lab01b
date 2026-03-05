package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private final Knight knight;
	private final Random random = new Random();
	private final int size;

    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
		Pair<Integer, Integer> knightPos = this.randomEmptyPosition();
        this.knight = new KnightImpl(size, knightPos.getX(), knightPos.getY());
    }

    public LogicsImpl(int size, Pair<Integer, Integer> pawn, Pair<Integer, Integer> knightPos) {
        this.size = size;
        this.pawn = pawn;
        this.knight = new KnightImpl(size, knightPos.getX(), knightPos.getY());
    }
    
	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		this.knight.move(row, col);
		return this.pawn.equals(new Pair<>(this.knight.getRow(), this.knight.getCol()));
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getRow() == row && this.knight.getCol() == col;
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
