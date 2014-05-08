package game

type Piece int

const E, X, O = Piece(0), Piece(1), Piece(2)

func stringify(p Piece) (str string) {
	
	switch p {
		case X:
			str = "X"
		case O:
			str = "O"
		case E:
			str = " "
	}
	return str
}

func (p Piece) String() string {
	return stringify(p)
}