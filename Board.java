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

    }

    public Boolean isLegal(Move m) {
    	//FIX ME
    	return false;
    }

    public Boolean isOver() {
    	//FIX ME
    	return false;
    }

}

