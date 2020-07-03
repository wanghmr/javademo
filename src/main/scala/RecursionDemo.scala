package main.scala

/**
  * @Author wh
  * @Date 2020/5/14 17:57
  *       Description:
  */
object RecursionDemo {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10)
      println(i + " 的阶乘为: = " + factorial(i))
  }

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }

}
