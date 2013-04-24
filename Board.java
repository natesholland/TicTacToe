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

