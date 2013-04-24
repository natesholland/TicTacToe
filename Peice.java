package TicTacToe;

public class Peice {

	/** the value for the tic tac toe peice*/
	private int num = 100;

	public int fromString(String s) {
		if (s =="X") {
			return 1;
		} else if (s == "O") {
			return 0;
		} else {
			//FIX ME
			return 100;
		}
	}

	public String toString() {
		if (num == 1) {
			return "X";
		} else if (num == 0) {
			return "O";
		} else if(num == -1) {
			return " ";
		} else {
			return "You have an error somewhere";
		}
	}

	public  Peice(int i) {
		num = i;
	}

	public Peice(String s) {
		if (s.equals("X")) {
			num = 1;
		} else if (s.equals("O")) {
			num = 0;
		} else if (s.equals(" ")) {
			num = -1;
		} else {
			System.out.println("something went wrong in Move");
			num = 100;
		}
	}

	public int getNum() {
		return num;
	}

	public void switchSide() {
		if (num == 1) {
			num = 0;
		} else if (num == 0) {
			num = 1;
		} else {
			num = 100;
		}
	}

	@Override
	public boolean equals(Object t) {
		Peice p = (Peice) t;
		return p.getNum() == num;
	}


}
