#!/usr/bin/ruby

load "Peice.rb"

class Move
	@position
	@side

	def initialize(p, s)
		@position = p
		@side = s
	end

	def getSide()
		return @side
	end

	def getPosition()
		return @position
	end

	def self.parseMove(string)
		a = string.split(" ")
		p = a[0]
		s = a[1]
		if (s == "X") 
			s = Peice.new(1)
		else
			s = Peice.new(0)
		end
		return Move.new(p, s)
	end

	def self.isMove(string)
		a = string.split(" ")
		if (a.length == 2)
			if(['1','2','3', '4','5','6','7','8','9'].include? a[0])
				if (['X', 'O'].include? a[1])
					return true
				end
			end
		end
		return false
	end

end