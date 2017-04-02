/**
  * Created by Dirk on 01.04.17.
  * https://gist.github.com/Akjir/5721503
  */


import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.scene.{Group, Scene}
import javafx.stage.Stage


package object gol {

  type Pos = (Int,Int)
    
  implicit class PosAdd(t: Pos) {
    def +(p: Pos) = (p._1 + t._1, p._2 + t._2)
  }
 
 object Board {
    val directions = List((-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1))
  }
 
 /** 2 dimensional finite board */
  class Board(val rows:Int, val cols:Int, val cells:Seq[Pos]) extends Traversable[Pos] {
    def neighbors(p:Pos)= Board.directions map { _ + p}
    override def foreach[U](f: (Pos => U)): Unit = cells.foreach(f)
 
 }
 
 class BoardCanvas(val board:Board,val fieldSize:Int) extends Canvas {
 
 this.setWidth(fieldSize * board.cols)
    this.setHeight(fieldSize * board.rows)
 
 def drawCell(p:Pos) {
   print("Zeichne " + p.toString)
   val gc = getGraphicsContext2D
   gc.setFill(Color.BLACK)
   gc.fillRect(fieldSize * p._1, fieldSize * p._2, fieldSize, fieldSize)
 }
 
 def repaint = board.foreach(drawCell(_))
 
 }


}

