package lectures.part1basics

object ValuesVariablesTypes extends App {

  // VALUES
  // val x: Int = 42   type is optional, COMPILER can infer types
  val x = 42
  println(x)

  // x = 3   not allowed, VALS ARE IMMUTABLE

  val aString: String = "hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 32000   // 2-bytes long
  val aLong: Long = 4353465645645646534L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // VARIABLES
  var aVariable: Int = 4

  aVariable = 5 // can be reassigned, side effects
}
