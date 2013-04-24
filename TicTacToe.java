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
				continue;
			} else if (move.equals("q")) {
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
			} else {
				System.out.println("I'm sorry I didn't recognize that command. These are the valid commands:");
				System.out.println("'q' will quit the program");
				System.out.println("'b' will print out the board so you can see it again");
				System.out.println("to make a move please enter two numbers separated by a space");
				System.out.println("the first number will be the column number (1-3)");
				System.out.println("the first number will be the row number (1-3)");
				System.out.println("so to place your peice in the middle right position you would enter '3 2'\n");
			}

		}
		System.out.println(b.toString());
		Peice winner = b.whoWon();
		if (winner.getNum() == -1) {
			System.out.println("It was a scratch");
		} else {
			System.out.println(winner.toString() + " won!");
		}
		System.exit(0);
	}

	public void not(){}

}