package main.scala

/**
  * @Author wh
  * @Date 2020/5/13 19:57
  *       Description:
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("--------scala开始-------------")
    println("中国,我爱你")
    println("--------scala结束---------------")
    var myVar = "Foo"
    myVar = "Too"
    val a2: String = "ddd"
    //    a2 = "aa";
    println(myVar)
    println(a2);

    var a = 10;
    var b = 20;
    var c = 25;
    var d = 25;
    println("a + b = " + (a + b));
    println("a - b = " + (a - b));
    println("a * b = " + (a * b));
    println("b / a = " + (b / a));
    println("b % a = " + (b % a));
    println("c % a = " + (c % a));

  }
}