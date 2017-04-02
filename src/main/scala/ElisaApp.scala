import javafx.scene.{Group, Scene}
import javafx.stage.Stage
import javafx.application.Application
import gol.{Board, BoardCanvas}

// Zelluläre Automaent (https://de.wikipedia.org/wiki/Zellul%C3%A4rer_Automat)
// aus Think "Complexity", Kapitel 8
// Scala plotting: Wisp, bokeh, breeze
// Java plotting: https://github.com/eseifert/gral/wiki/comparison

/**
  * Created by Dirk on 01.04.17.
  */
class ElisaApp extends Application {

  def start(stage: Stage) {
    val root = new Group
    val scene = new Scene(root)
    val stage = new Stage

    val board = new Board(11,11,List((5,5)))
    val boardCanvas = new BoardCanvas(board,50)


    boardCanvas.repaint
    root.getChildren.add(boardCanvas)
    stage.setTitle("Elisa")
    stage.centerOnScreen
    stage.setScene(scene)
    stage.show
  }

}

object ElisaApp extends App {
  //print("Hello World")
  Application.launch(classOf[ElisaApp], args: _*)
}