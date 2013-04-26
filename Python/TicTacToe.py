class Piece:
	EX, OH, BLANK = 'X', 'O', ' '
class Board:
	def __init__(self):
		self.current, self.board = Piece.EX, [Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK, Piece.BLANK]
	def switchPlayer(self):
		self.current = Piece.OH if (self.current is Piece.EX) else Piece.EX
	def makeMove(self, move):
		try:
			if (self.board[int(move) - 1] is Piece.BLANK):
				self.board[int(move) - 1] = self.current
				return 1
			else: return 0
		except: return 0
	def isOver(self):
		isFull = Piece.BLANK
		for a,b,c in [[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]:
			if (self.board[a] is self.board[b] is self.board[c] and self.board[a] is not Piece.BLANK): return self.board[a]
			if (self.board[a] is Piece.BLANK or self.board[b] is Piece.BLANK or self.board[c] is Piece.BLANK): isFull = False
		return isFull
	def __str__(self):
		return "\n{0}|{1}|{2}\n-----\n{3}|{4}|{5}\n-----\n{6}|{7}|{8}\n".format(self.board[0], self.board[1], self.board[2], self.board[3], self.board[4], self.board[5], self.board[6], self.board[7], self.board[8])
def main():
	print("Welcome to TicTacToe")
	board = Board()
	while (not board.isOver()):
		print("It is {0}'s turn".format(board.current) + board.__str__())
		move = input('Where would you like to go? : ').strip()
		if (move == 'q'): break
		elif (board.makeMove(move) == 1): board.switchPlayer()
		else:
			print("I didn't understand your input, these are the valid inputs:\nentering 'q' will quit out of the game.\n")
			print("entering a number will place the peice in that box, the numbers are as follows:\n \n1|2|3\n-----\n4|5|6\n-----\n7|8|9\n")
	print(board.__str__() + "\nGame Over")
	print("Player {0} wins!".format(board.isOver())) if (board.isOver() is Piece.EX or board.isOver() is Piece.OH) else print("It was a draw")
main()