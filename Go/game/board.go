package game

// import "fmt"

type Board struct{
	layout [9]Piece
}

func NewBoard() (b *Board) {
	b = &Board{layout: [9]Piece{E, E, E, E, E, E, E, E, E}}
	return
}

