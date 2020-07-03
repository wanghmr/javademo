package main.scala

import java.io.PrintWriter

import scala.io.{Source, StdIn}

/**
  * @Author wh
  * @Date 2020/5/19 18:30
  *       Description:
  */
object IoDemo {

  def main(args: Array[String]): Unit = {
    //Scala 进行文件写操作，直接用的都是 java中 的 I/O 类 （java.io.File)：
    writer()
    //有时候我们需要接收用户在屏幕输入的指令来处理程序。
    read()
    //从文件上读取内容
    fileRead()
  }

  def writer(): Unit = {
    val writer = new PrintWriter("test.txt")
    writer.write("菜鸟教程")
    writer.close()
  }

  def read(): Unit = {
    print("请输入菜鸟教程官网 : ")
    //Scala2.11 后的版本 Console.readLine 已废弃，使用 scala.io.StdIn.readLine() 方法代替。
    val line = StdIn.readLine()
    println("谢谢，你输入的是: " + line)
  }

  def fileRead(): Unit = {
    print("文件内容为:")
    Source.fromFile("test.txt").foreach {
      print
    }
    println
  }
}
