package main.scala

/**
  * @Author wh
  * @Date 2020/5/14 18:21
  *       Description:
  */
object StringBuilder {
  def main(args: Array[String]): Unit = {
    var sb = new StringBuilder
    sb ++= "hha";
    sb ++= "match"
    println(sb)
    var buf = new StringBuilder
    buf += 'a'
    buf ++= "bcdef"
    println("buf is : " + buf.toString)

    sb.++=("55")
    println("sb is : " + sb.toString())
    println("-----------" + sb.toString().concat(buf.toString()))
    var c = sb.toString()
    var d = buf.toString()

    println("-----------" + c.concat(d))

    var str1 = "菜鸟教程官网：";
    var str2 = "www.runoob.com";
    var str3 = "菜鸟教程的 Slogan 为：";
    var str4 = "学的不仅是技术，更是梦想！";
    println(str1 + str2);
    println(str3.concat(str4));


    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "菜鸟教程!"
    var fs = printf("浮点型变量为 " +
      "%f, 整型变量为 %d, 字符串为 " +
      " %s", floatVar, intVar, stringVar)
    println(fs)
  }

}
