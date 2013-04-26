
class Piece:
	""" This is a simple Peice class using an Enum to only allow X, O, and BLANK """
	EX, OH, BLANK = 'X', 'O', ' '

class Board:
	""" This is the main class which has most of the game flow in it."""

	def __init__(self):
		""" Initializing method. Always starts with player 'X' going first.
		Also creates a blank board to begin playing on. """
		self.current = Piece.EX
		self.board = [Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK]
	
	def switchPlayer(self):
		"""Switches whose turn it is."""
		if (self.current is Piece.EX):
			self.current = Piece.OH 
		else:
			self.current = Piece.EX
	
	def makeMove(self, move):
		"""Trys to make a move. If the move is successful returns 1.
		If the move string is not able to interpreted correctly or if
		that place is already full the move fails and the function returns 0 """
		try:
			if (self.board[int(move) - 1] is Piece.BLANK):
				self.board[int(move) - 1] = self.current
				return 1
			else:
				return 0
		except:
			return 0
	
	def isOver(self):
		"""Returns the winning peice if the game is over.
		If the game is a draw it returns the empty peice,
		and if the game is not over returns false."""
		isFull = Piece.BLANK
		for a,b,c in [[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]:
			if (self.board[a] is self.board[b] is self.board[c] and self.board[a] is not Piece.BLANK):
				return self.board[a]
			if (self.board[a] is Piece.BLANK or self.board[b] is Piece.BLANK or self.board[c] is Piece.BLANK):
				isFull = False
		return isFull
	
	def __str__(self):
		"""Returns a string interpretation of the board. """
		boardString = "\n{0}|{1}|{2}\n-----\n{3}|{4}|{5}\n-----\n{6}|{7}|{8}\n"
		return boardString.format(self.board[0], self.board[1], self.board[2], self.board[3],
			self.board[4], self.board[5], self.board[6], self.board[7], self.board[8])

def main():
	"""The main method for running the game.
	entering q quits the game and otherwise enter the number for the following positions:
	1|2|3
	-----
	4|5|6
	-----
	7|8|9
	"""
	print("Welcome to TicTacToe")
	board = Board()
	while (not board.isOver()):
		print("It is {0}'s turn".format(board.current) + board.__str__())
		move = input('Where would you like to go? : ').strip()
		if (move == 'q'):
			break
		elif (board.makeMove(move) == 1):
			board.switchPlayer()
		else:
			print("I didn't understand your input, these are the valid inputs:\nentering 'q' will quit out of the game.\n")
			print("entering a number will place the peice in that box, the numbers are as follows:\n \n1|2|3\n-----\n4|5|6\n-----\n7|8|9\n")
	print(board.__str__() + "\nGame Over")
	if (board.isOver() is Piece.EX or board.isOver() is Piece.OH):
		print("Player {0} wins!".format(board.isOver()))  
	else:
		print("It was a draw")

main()
