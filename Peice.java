package TicTacToe;

public class Peice {

	/** the value for the tic tac toe peice
	* a 1 coresponds to an X and a 0 coresponds to an O. */
	private int num = 100;

	/** Method that parses a string and turns it into am int.
	* I actually don't know if I ever use this. */
	public int fromString(String s) {
		if (s =="X") {
			return 1;
		} else if (s == "O") {
			return 0;
		} else {
			return 100;
		}
	}

	/** The toString method for the Peice. */
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

	/** A peice constructor that takes in an int and sets that as the number for the peice. */
	public  Peice(int i) {
		num = i;
	}

	/** Method that parses a string and turns it into a Peice. */
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

	/** Method that returns the number. */
	public int getNum() {
		return num;
	}

	/** A method that switches what side the peice is on. This is used
	* for when we want to switch what side is playing. */
	public void switchSide() {
		if (num == 1) {
			num = 0;
		} else if (num == 0) {
			num = 1;
		} else {
			num = 100;
		}
	}
gi
	@Override
	public boolean equals(Object t) {
		Peice p = (Peice) t;
		return p.getNum() == num;
	}


}
