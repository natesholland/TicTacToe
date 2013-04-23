package TicTacToe;

import java.io.*;
import java.util.Scanner;


public class TicTacToe {

	public static void main (String args[]) {
		Board b = new Board();
		Scanner sIn = new Scanner(System.in);
		Peice playerTurn = new Peice(1);
		while (!b.isOver()) {
			System.out.println("It is " + playerTurn.toString() +"\'s turn");
			System.out.println(b.toString());
			System.out.print(">>>");
			String move = sIn.nextLine();
			move = move.trim();
				if (move.equals("b")) {
					System.out.println(b.toString());
				}
				if (move.equals("q")) {
					System.exit(0);
				}
			move = move + " " + playerTurn.toString();
			if (Move.isMove(move)) {
				Move m = Move.parseMove(move);

				if (b.isLegal(m)) {
					b.makeMove(m);
					playerTurn.switchSide();
				} else {
					System.out.println("That was an illegal move");
				}
			}

		}



	}

	public void not(){}

}