#!/usr/bin/ruby
load "Move.rb"
load "Board.rb"
load "Peice.rb"

class TicTacToe

	def runGame()
		b = Board.new
		playerTurn = Peice.new(1)
		did_show_b = false
		while(!b.isOver())
			puts ""
			if (!did_show_b)
				puts b
			end
			puts("it is " + playerTurn.to_s + "'s turn, please move")
			STDOUT.flush
			#moveChecker = Move.new
			input = gets.chomp.downcase
			if input == "q"
				break
			elsif input == "b"
				puts b.showNumbers
				did_show_b = true
				next
			end
			did_show_b = false
			input = input + " " + playerTurn.to_s
			if (Move.isMove(input))
				m = Move.parseMove(input)
				if (b.isLegal(m))
					b.makeMove(m)
					playerTurn.switchSide
				else
					puts "I'm sorry that was not a legal move"
				end
			else
				puts "I'm sorry I didn't recognize your input, here are the possible inputs:"
				puts "you can enter 'b' to show the board with all the numbers for indexing"
				puts "you can enter 'q' in order to quit the game at any time"
				puts "you can enter the number of whatever space you want to play in"
			end	

		end
		puts b
		winner = b.whoWon()
		if winner.getNum() == -1
			puts "It was a scratch"
		else
			puts winner.to_s + " won!"
		end


	end
end

t = TicTacToe.new
t.runGame()