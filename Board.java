package TicTacToe;

public class Board {

	private Peice[][] board;

    public Board() {
    	board = new Peice[3][3];
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<3; j++) {
    			board[i][j] = new Peice(-1);
    		}
    	}
    }

    public void makeMove(Move m) {
    	System.out.println(m.toString());
    	board[m.getCol() - 1][m.getRow() - 1] = m.getPeice();
    }

    public Boolean isLegal(Move m) {
    	if (!isOver()) {
    		if (board[m.getCol() - 1][m.getRow()- 1].getNum() == -1) {
    			return true;
    		}
    	}
    	return false;
    }

    public Boolean isOver() {
    	int[][][] solutions = {{{}}}
    	return false;
    }

    public String toString() {
    	String s = "";
			s = s + board[0][0] + "|" + board[1][0] + "|" + board[2][0] + "\n";
			s += "______\n";
			s = s + board[0][1] + "|" + board[1][1] + "|" + board[2][1] + "\n";
			s += "______\n";
			s = s + board[0][2] + "|" + board[1][2] + "|" + board[2][2] + "\n";
			return s;
    }

}

