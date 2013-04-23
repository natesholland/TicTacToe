package TicTacToe;

public class Move {
	
	private int col;

	private int row;

	private Peice p;


	public Move(int col, int row, Peice p) {
		col = col;
		row = row;
		p = p;
	}

	public Move() {}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public Peice getPeice() {
		return p;
	}

	public static Move parseMove(String s) {
		// FIX ME
		return new Move();
	}

	public static boolean isMove(String s) {
		return false;
	}
}