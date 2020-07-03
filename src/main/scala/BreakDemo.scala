package main.scala

import scala.util.control.Breaks

/**
  **/
object BreakDemo {

  def main(args: Array[String]): Unit = {
    val arrays = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = new Breaks
    root.breakable {
      for (a <- arrays) {
        println("循环值：" + a)
        if (a == 4) {
          println("跳出循环")
          root.break()
        }
      }
    }
    println("After the loop")
  }

}
