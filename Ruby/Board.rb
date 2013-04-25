#!/usr/bin/ruby
load "Peice.rb"

class Board

	def initialize()
		@peices = [Peice.new(-1), Peice.new(-1), Peice.new(-1), Peice.new(-1), Peice.new(-1), Peice.new(-1), Peice.new(-1), Peice.new(-1), Peice.new(-1)]
	end
	
	def isOver()
		endOptions = [[0, 1, 2,], [3, 4, 5], [6, 7, 8], \
			[0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]];
		for e in endOptions
			if (@peices[e[0]] == @peices[e[1]] && @peices[e[0]] == @peices[e[2]] && @peices[e[0]].getNum != -1)
				return true
			end
		end
		isFull = true
		for i in 0..8
			if @peices[i].getNum() == -1
				isFull = false
			end
		end
		return isFull;
	end

	def whoWon()
		endOptions = [[0, 1, 2,], [3, 4, 5], [6, 7, 8], \
			[0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]];
		for e in endOptions
			if (@peices[e[0]] == @peices[e[1]] && @peices[e[0]] == @peices[e[2]] && @peices[e[0]].getNum != -1)
				return @peices[e[0]];
			end
		end
		return Peice.new(-1)
	end

	def isLegal(move)
		if (@peices[move.getPosition().to_i - 1].getNum() == -1 && !isOver())
			return true;
		else
			return false;
		end
	end

	def makeMove(move)
		@peices[move.getPosition.to_i - 1] = move.getSide
	end

	def showNumbers()
		s = ""
		if @peices[0].getNum == -1
			s = s + "1"
		else 
			s = s + @peices[0].to_s	
		end
		s = s + "|"
		if @peices[1].getNum == -1
			s = s + "2"
		else 
			s = s + @peices[1].to_s	
		end
		s = s + "|"
		if @peices[2].getNum == -1
			s = s + "3"
		else 
			s = s + @peices[2].to_s	
		end
		s = s + "\n"
		s += "______\n";
		if @peices[3].getNum == -1
			s = s + "4"
		else 
			s = s + @peices[3].to_s	
		end
		s = s + "|"
		if @peices[4].getNum == -1
			s = s + "5"
		else 
			s = s + @peices[4].to_s	
		end
		s = s + "|"
		if @peices[5].getNum == -1
			s = s + "6"
		else 
			s = s + @peices[5].to_s	
		end
		s = s + "\n"
		s += "______\n";
		if @peices[6].getNum == -1
			s = s + "7"
		else 
			s = s + @peices[6].to_s	
		end
		s = s + "|"
		if @peices[7].getNum == -1
			s = s + "8"
		else 
			s = s + @peices[7].to_s	
		end
		s = s + "|"
		if @peices[8].getNum == -1
			s = s + "9"
		else 
			s = s + @peices[8].to_s	
		end
		s = s + "\n"
		return s
	end


	def to_s()
		s = ""
		s = s + @peices[0].to_s + "|" + @peices[1].to_s + "|" + @peices[2].to_s + "\n";
			s += "______\n";
			s = s + @peices[3].to_s + "|" + @peices[4].to_s + "|" + @peices[5].to_s + "\n";
			s += "______\n";
			s = s + @peices[6].to_s + "|" + @peices[7].to_s + "|" + @peices[8].to_s + "\n";
	end
end