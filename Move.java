package TicTacToe;

public class Move {
	/** Value that holds the column of the move. */
	private int col;
	/** Value that holds the row of the move. */
	private int row;
	/** This is the value that hold what peice is being placed. */
	private Peice p;

	/** Constructor that creates a new move. Takes in c for column, r for row, and pei for peice. */
	public Move(int c, int r, Peice pei) {
		col = c;
		row = r;
		p = pei;
	}

	/** Null constructor. Shouldn't be used */
	public Move() {}

	/** Method which returns the Column int. */
	public int getCol() {
		return col;
	}
	/** Method which returns the Row int. */
	public int getRow() {
		return row;
	}
	/** Returns the Peice of the move. */
	public Peice getPeice() {
		return p;
	}
	/** This method parses the input string and creates a move out of it. */
	public static Move parseMove(String s) {
		String[] args = s.split(" ");
		int col = Integer.parseInt(args[0]);
		int row = Integer.parseInt(args[1]);
		Peice p = new Peice(args[2]);
		return new Move(col, row, p);
	}

	/** This method takes in a string and returns true if and only if the move is a legal move. */
	public static boolean isMove(String s) {
		String[] args = s.split(" ");
		try {
			int col = Integer.parseInt(args[0]);
			int row = Integer.parseInt(args[1]);
			if (col > 3 || col < 1) {
				return false;
			}
			if (row > 3 || row < 1) {
				return false;
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	/** Method to turn the move into a string. This is mainly to be used in debugging. */
	public String toString() {
		String s = "";
		s = s + Integer.toString(col);
		s = s + " " + Integer.toString(row);
		s = s + " " + p.toString();
		return s;
	}
}