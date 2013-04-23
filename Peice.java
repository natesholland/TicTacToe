package TicTacToe;

public class Peice {

	/** the value for the tic tac toe peice*/
	private int num;

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


}
