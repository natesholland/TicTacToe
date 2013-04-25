package TicTacToe;

public class Board {

    /** Private 2D array of Peices which serves as the Tic Tac Toe board. 
    * This easily could have been stored as a single array but I decided to
    * make it a 2D array for kicks. */
	private Peice[][] board;

    /** Board constructor which creates a board of empty peices. */
    public Board() {
    	board = new Peice[3][3];
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<3; j++) {
    			board[i][j] = new Peice(-1);
    		}
    	}
    }

    /** Method that takes in a move and makes it on the board. */
    public void makeMove(Move m) {
    	board[m.getCol() - 1][m.getRow() - 1] = m.getPeice();
    }

    /** Checks if a move is legal, basically makes sure the game isn't over
    * and where you are moving isn't full. */
    public Boolean isLegal(Move m) {
    	if (!isOver()) {
    		if (board[m.getCol() - 1][m.getRow()- 1].getNum() == -1) {
    			return true;
    		}
    	}
    	return false;
    }

    /** Checks if the game is over. Checks for solutions as well as a full board. */
    public Boolean isOver() {
    	int[][][] solutions = {{{1, 2, 3}, {1, 2, 3}}, {{1, 1, 1},{1, 2, 3}}, {{2, 2, 2},{1, 2, 3}},
    		{{3, 3, 3},{1, 2, 3}}, {{1, 2, 3},{1, 1, 1}}, {{1, 2, 3},{2, 2, 2}}, 
    		{{1, 2, 3},{3, 3, 3}}, {{1, 2, 3}, {3, 2, 1}}}; 
    	for (int[][] sol : solutions) {
            Peice q = board[sol[0][0] - 1][sol[1][0] - 1];
            Peice w = board[sol[0][1] - 1][sol[1][1] - 1];
            Peice e = board[sol[0][2] - 1][sol[1][2] - 1];
    		if (q.getNum() ==  w.getNum() && q.getNum() ==  e.getNum()
                && (board[sol[0][0] - 1][sol[1][0] - 1].getNum() == 0 || 
                    board[sol[0][0] - 1][sol[1][0] - 1].getNum() == 1)) {
    				return true;
    		}
    	}
        int[][] isFull = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        Boolean full = true;
        for (int[] i : isFull) {
            if (board[i[0]][i[1]].getNum() == -1) {
                full = false;
            }
        }
    	return full;
    }

    /** Method that returns the peice of who won. If it is a draw it returns the empty peice. */
    public Peice whoWon() {
        int[][][] solutions = {{{1, 2, 3}, {1, 2, 3}}, {{1, 1, 1},{1, 2, 3}}, {{2, 2, 2},{1, 2, 3}},
            {{3, 3, 3},{1, 2, 3}}, {{1, 2, 3},{1, 1, 1}}, {{1, 2, 3},{2, 2, 2}}, 
            {{1, 2, 3},{3, 3, 3}}, {{1, 2, 3}, {3, 2, 1}}}; 

        for (int[][] sol : solutions) {
            Peice q = board[sol[0][0] - 1][sol[1][0] - 1];
            Peice w = board[sol[0][1] - 1][sol[1][1] - 1];
            Peice e = board[sol[0][2] - 1][sol[1][2] - 1];
            if (q.getNum() ==  w.getNum() && q.getNum() ==  e.getNum()
                && (board[sol[0][0] - 1][sol[1][0] - 1].getNum() == 0 || 
                    board[sol[0][0] - 1][sol[1][0] - 1].getNum() == 1)) {
                    return board[sol[0][0] - 1][sol[1][0] - 1];
            }
        }
        return new Peice(-1);
    }

    /** To string method for the board. This is used to print out the board and show the player the game status. */
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

