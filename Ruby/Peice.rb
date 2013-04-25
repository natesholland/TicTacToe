#!/usr/bin/ruby
class Peice
	@number

	def initialize(i)
		@number = i
	end

	def getNum()
		return @number
	end

	def ==(p)
		if p.getNum == @number
			return true
		else
			return false
		end
	end

	def to_s()
		if (@number == 1) 
			return "X"
		elsif (@number == 0) 
			return "O"
		elsif (@number == -1)
			return " "
		else 
			return "something went really wrong"
		end
	end

	def switchSide()
		if @number == 1
			@number = 0
		else 
			@number = 1
		end
	end
end