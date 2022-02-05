package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // Similar to Java
  println(str.charAt(2))  // l
  println(str.substring(7, 11))  // I am
  println(str.split(" ").toList)  // List(Hello,, I, am, learning, Scala)
  println(str.startsWith("Hello"))  // true
  println(str.replace(" ", "-"))  // Hello,-I-am-learning-Scala
  println(str.toLowerCase())  // hello, i am learning scala
  println(str.length)  // 26

  // Scala
  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)  // 45
  println('a' +: aNumberString :+ 'z')  // a45z
  println(str.reverse)  // alacS gninrael ma I ,olleH
  println(str.take(2))  // He

  // Scala-specific: String interpolator (S-interpolator)
  val name = "Tomek"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old."
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old."

  // F-interpolator
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute!" // 2 characters total, minimum 2 decimals precision
  // Tomek can eat 1.20 burgers per minute!
  print(myth)

  // raw-interpolator
  println(raw"This is a \n newline")  // printing literally
  val escaped = "This is a \n newline"
  println(raw"$escaped")  // print in two lines
}
