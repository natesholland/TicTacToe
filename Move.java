package TicTacToe;

public class Move {
	
	private int col;

	private int row;

	private Peice p;


	public Move(int c, int r, Peice pei) {
		col = c;
		row = r;
		p = pei;
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
		System.out.println(s);
		String[] args = s.split(" ");

		int col = Integer.parseInt(args[0]);
		int row = Integer.parseInt(args[1]);
		Peice p = new Peice(args[2]);
		System.out.println(Integer.toString(col) + " " + Integer.toString(row) + " " + p.toString());
		System.out.println(p);
		return new Move(col, row, p);
	}

	public static boolean isMove(String s) {
		String[] args = s.split(" ");
		try {
			int col = Integer.parseInt(args[0]);
			int row = Integer.parseInt(args[0]);
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

	public String toString() {
		String s = "";
		s = s + Integer.toString(col);
		s = s + " " + Integer.toString(row);
		s = s + " " + p.toString();
		return s;
	}
}