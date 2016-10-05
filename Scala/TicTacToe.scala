class Piece {
  // This is basically an enum but I don't feel like figuring out that syntax
  var num = 0

  // be able to create a Piece based on the string representation of it
  def this(string_input: String) {
    this()
    if (string_input == "X") {
      this.num = 1
    } else if (string_input == "O") {
      this.num = -1
    } else {
      throw new IllegalArgumentException("Input String to Peice was not X or O")
    }
  }

  // Have a way to create the object by passing in an int
  def this(num_input: Int) {
    this()
    this.num = num_input
  }

  def canEqual(a: Any) = a.isInstanceOf[Piece]

  override def equals(that: Any): Boolean =
  that match {
    case that: Piece => that.canEqual(this) && this.num == that.num
    case _ => false
 }

  // This is how we represent a Piece as a String
  override def toString: String = {
    if (num == 1) {
      return "X"
    } else if (num == -1) {
      return "O"
    } else {
      return " "
    }
  }
}

class Board {
  var layout = Array.fill[Piece](9)(new Piece(0))
  var current_player = new Piece(1)

  override def toString: String = {
    var s = ""
    s = s + layout(0) + "|" + layout(1) + "|" + layout(2) + "\n"
    s += "______\n"
    s = s + layout(3) + "|" + layout(4) + "|" + layout(5) + "\n"
    s += "______\n"
    s = s + layout(6) + "|" + layout(7) + "|" + layout(8) + "\n"
    return s
  }

  def switchPlayer = {
    if (current_player == new Piece(1)) {
      current_player = new Piece(-1)
    } else {
      current_player = new Piece(1)
    }
  }

  def isOver: Boolean = {
    var winning_options = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8), Array(0, 3, 6), Array(1, 4, 7), Array(2, 5, 8), Array(0, 4, 8), Array(2, 4, 6))
    for (options <- winning_options) {
      if (layout(options(0)) == layout(options(1)) && layout(options(0)) == layout(options(2)) && layout(options(0)) != new Piece(0)) {
        println(layout(options(0)).toString() + " wins!")
        return true
      }
    }
    return false
  }

  def isLegal(move: String): Boolean = {
    try {
      val move_int = move.toInt
      if (move_int < 0 || move_int > 8) {
        return false
      }
      if (layout(move_int).num != 0) {
        return false
      }
      return true
    } catch {
    case e : Throwable => return false
    }
  }

  def makeMove(move: String): Boolean = {
    if (isLegal(move)) {
      val move_int = move.toInt
      layout(move_int) = current_player
      return true
    } else {
      return false
    }
  }
}



object TicTacToe {
  def main(args: Array[String]) {
    println("Hello world")
    val p = new Piece(1)
    println(p.toString())
    val b = new Board()
    println(b)
    while(!b.isOver) {
      var move = scala.io.StdIn.readLine()
      var move_result = b.makeMove(move)
      if (move_result) {
        b.switchPlayer
        println(b)
      } else {
        println("I'm sorry, I didn't understand your input")
      }
    }
  }

}
